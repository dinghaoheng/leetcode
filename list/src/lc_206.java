public class lc_206 {
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
