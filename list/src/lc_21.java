public class lc_21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode pre = new ListNode();
        ListNode temp = pre;
        while (list1 != null && list2 != null) {
            if (list1.val >= list2.val) {
                temp.next = list2;
                list2 = list2.next;
            } else {
                temp.next = list1;
                list1 = list1.next;
            }
            temp = temp.next;
        }
        if (list1 != null) {
            temp.next = list1;
        }
        if (list2 != null) {
            temp.next = list2;
        }
        return pre.next;
    }
}
