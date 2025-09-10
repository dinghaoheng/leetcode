public class lc_203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode temp = new ListNode(0, head);
        ListNode dummy = temp;
        while (dummy.next != null) {
            if (dummy.next.val == val) {
                dummy.next = dummy.next.next;
                continue;
            }
            dummy = dummy.next;
        }
        return temp.next;
    }

}
