public class lc_142 {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            /**
             * 当快慢指针相遇时
             * 起点到入口的距离等于交点到入口的距离
             */
            if (fast == slow) {
                ListNode temp = head;
                while (temp != fast) {
                    temp = temp.next;
                    fast = fast.next;
                }
                return temp;
            }
        }
        return null;
    }
}
