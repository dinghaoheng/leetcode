public class lc_206 {
    public static void main(String[] args) {
        ListNode node = ListNode.getNode(new int[]{1, 2, 3, 4, 5});
        new lc_206().reverseList(node);
    }
    public ListNode reverseList(ListNode head) {
        ListNode pre = new ListNode();
        ListNode temp = null;
        while (head != null) {
            temp = head.next;
            head.next = pre.next;
            pre.next = head;
            head = temp;
        }
        return pre.next;
    }
}
