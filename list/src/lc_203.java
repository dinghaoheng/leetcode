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


    public static void main(String[] args) {
        ListNode node = ListNode.getNode(new int[]{7,7,7,7});
        new lc_203().removeElements2(node,7);
    }

    public ListNode removeElements2(ListNode head, int val) {
        ListNode dummy=new ListNode();
        dummy.next=head;
        ListNode temp=dummy;
        while (temp!=null&&temp.next!=null){
            if (temp.next.val==val){
                temp.next=temp.next.next;
            }
            temp=temp.next;
        }
        return dummy.next;
    }

}
