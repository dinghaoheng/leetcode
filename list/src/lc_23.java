import java.util.PriorityQueue;

public class lc_23 {

    PriorityQueue<CompareNode> queue=new PriorityQueue<>();
    public ListNode mergeKLists(ListNode[] lists) {
        for(ListNode item : lists){
            if (item==null){
                continue;
            }
            queue.add(new CompareNode(item.val,item));
        }
        ListNode pre=new ListNode();
        ListNode temp=pre;
        while (!queue.isEmpty()){
            CompareNode node = queue.remove();
            temp.next=node.listNode;
            ListNode next=node.listNode.next;
            if (next!=null){
                queue.add(new CompareNode(next.val,next));
            }
            temp=temp.next;
        }
        return pre.next;
    }
    public static class CompareNode implements Comparable<CompareNode>{
        private int value;
        private ListNode listNode;
        @Override
        public int compareTo(CompareNode o) {
            return listNode.val-o.value;
        }
        public CompareNode(){

        }
        public CompareNode(int val,ListNode listNode){
            this.value=val;
            this.listNode=listNode;
        }
    }

    public ListNode mergeKLists2(ListNode[] lists) {
        if(lists.length==0){
            return null;
        }
        if (lists.length==1){
            return lists[0];
        }
        ListNode result=lists[0];
        for(int i=1;i<lists.length;i++){
            result=merge(result,lists[i]);
        }
        return result;
    }
    private ListNode merge(ListNode nodeA,ListNode nodeB){
        ListNode pre=new ListNode();
        ListNode temp=pre;
        while(nodeA!=null&&nodeB!=null){
            if (nodeA.val<=nodeB.val){
                temp.next=nodeA;
                nodeA=nodeA.next;
            }else {
                temp.next=nodeB;
                nodeB=nodeB.next;
            }
            temp=temp.next;
        }
        if (nodeA!=null){
            temp.next=nodeA;
        }else {
            temp.next=nodeB;
        }
        return pre.next;
    }
}
