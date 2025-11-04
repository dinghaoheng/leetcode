import java.util.HashMap;
import java.util.Map;

public class lc_138 {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node pre = new Node(0);
        Node temp = pre;
        Node temp2 = head;
        while (temp2 != null) {
            Node node = new Node(temp2.val);
            map.put(temp2, node);
            temp.next = node;
            temp = temp.next;
            temp2 = temp2.next;
        }
        Node temp3 = head;
        Node temp4 = pre;
        while (temp3 != null) {
            if (temp3.random != null) {
                temp4.next.random = map.get(temp3.random);
            }
            temp3 = temp3.next;
            temp4 = temp4.next;
        }
        return pre.next;
    }
}
