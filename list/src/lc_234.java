public class lc_234 {
    /**
     * 本体可以将链表转换成数字，再校验数字是否为回文串，这样做的空间复杂度为o(n)
     * 为了实现空间复杂度为o(1)，讲链表分为两部分，再倒转后面那部分链表，再去判断两个链表是否完全相同
     */
    public boolean isPalindrome(ListNode head) {
        ListNode half = getHalf(head);
        ListNode reverseHalf = reverse(half.next);
        ListNode node1 = head;
        ListNode node2 = reverseHalf;
        while (node1 != null && node2 != null) {
            if (node1.val != node2.val) {
                return false;
            }
            node1 = node1.next;
            node2 = node2.next;
        }
        return true;
    }

    private ListNode reverse(ListNode node) {
        ListNode pre = new ListNode();
        ListNode temp = node;
        while (temp != null) {
            ListNode next = temp.next;
            temp.next = pre.next;
            pre.next = temp;
            temp = next;
        }
        return pre.next;
    }

    private ListNode getHalf(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
