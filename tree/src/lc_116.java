import java.util.ArrayDeque;
import java.util.Deque;

public class lc_116 {

    public static void main(String[] args) {
        lc_116 lc116 = new lc_116();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.left = node7;
        lc116.connect(node1);
    }

    public Node connect(Node root) {
        Deque<Node> deque=new ArrayDeque<>();
        if (root==null){
            return null;
        }
        deque.addFirst(root);
        while (!deque.isEmpty()){
            int size=deque.size();
            Node first=deque.peekLast();
            for (int i=0;i<size;i++){
                Node node=deque.removeLast();
                if (i!=0){
                    first.next=node;
                    //记录前一个节点
                    first=node;
                }
                if (node.left!=null){
                    deque.addFirst(node.left);
                }
                if (node.right!=null){
                    deque.addFirst(node.right);
                }
            }
        }
        return root;
    }

    private static class Node {
        int val;
        Node left;
        Node right;
        Node next;

        public Node() {

        }

        public Node(int val) {
            this.val=val;
        }
    }
}
