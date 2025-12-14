import java.util.HashMap;
import java.util.Map;

public class LFUCache {
    private static class Node{
        int key;
        int value;
        int freq=1;
        Node pre;
        Node next;
    }
    int capacity;
    Map<Integer,Node> keyToNode=new HashMap<>();
    Map<Integer,Node> freqToNode=new HashMap<>();
    int minFreq;


    public LFUCache(int capacity) {
        this.capacity=capacity;
    }

    public int get(int key) {
        Node node=getNode(key);
        return node==null ? -1 : node.value;
    }

    public void put(int key, int value) {
        Node node=getNode(key);
        if(node!=null){
            node.value=value;
            return;
        }
        node=new Node();
        node.key=key;
        node.value=value;
        //超出容量时，移除元素
        if(keyToNode.size()==capacity){
            Node dummy=freqToNode.get(minFreq);
            keyToNode.remove(dummy.pre.key);
            remove(dummy.pre);
            if(dummy.pre==dummy){
                freqToNode.remove(minFreq);
            }
            minFreq++;
        }
        keyToNode.put(key,node);
        Node dummy=freqToNode.get(1);
        if(dummy==null){
            dummy=newDummy();
            freqToNode.put(1,dummy);
        }
        addToFront(node,dummy);
        minFreq=1;
    }
    private Node getNode(int key){
        if(!keyToNode.containsKey(key)){
            return null;
        }
        //从原来的序列中删除
        Node node=keyToNode.get(key);
        remove(node);
        //判断原来的序列是否需要清空
        Node dummy=freqToNode.get(node.freq);
        if(dummy.pre==dummy){
            freqToNode.remove(node.freq);
            if(node.freq==minFreq){
                minFreq++;
            }
        }
        //加入到新的序列
        int newFreq=node.freq+1;
        Node newdummy=freqToNode.get(newFreq);
        if(newdummy==null){
            newdummy=newDummy();
            freqToNode.put(newFreq,newdummy);
        }
        addToFront(node,newdummy);
        node.freq=newFreq;
        return node;
    }

    private Node newDummy(){
        Node node=new Node();
        node.next=node;
        node.pre=node;
        return node;
    }

    private void addToFront(Node node,Node dummy){
        Node next=dummy.next;
        dummy.next=node;
        next.pre=node;
        node.next=next;
        node.pre=dummy;
    }
    private void remove(Node node){
        Node pre=node.pre;
        Node next=node.next;
        pre.next=next;
        next.pre=pre;
    }
}
