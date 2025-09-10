public class lc_24 {
    public ListNode swapPairs(ListNode head) {
        ListNode pre = new ListNode();
        pre.next = head;
        ListNode dummy = pre;
        while (dummy.next != null && dummy.next.next != null) {
            ListNode temp1 = dummy.next.next.next;
            ListNode temp2 = dummy.next;
            dummy.next = dummy.next.next;
            dummy.next.next = temp2;
            temp2.next = temp1;
            dummy = temp2;
        }
        return pre.next;
    }
}
