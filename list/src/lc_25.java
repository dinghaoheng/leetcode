public class lc_25 {
    public static void main(String[] args) {
        ListNode node = ListNode.getNode(new int[]{1, 2, 3, 4,5});
        new lc_25().reverseKGroup2(node, 2);
    }

        public ListNode reverseKGroup2(ListNode head, int k) {
            ListNode pre= new ListNode(0,head);
            ListNode temp=pre;
            while(temp.next!=null){
                ListNode tail=temp;
                for(int i=0;i<k;i++){
                    tail=tail.next;
                    if(tail==null){
                        return pre.next;
                    }
                }
                ListNode nextNode=tail.next;
                ListNode[] reverse=reverse2(head,tail);
                head=reverse[0];
                tail=reverse[1];
                tail.next=nextNode;
                temp.next=head;
                temp=tail;
                head=tail.next;
            }
            return pre.next;
        }

        private ListNode[] reverse2(ListNode head,ListNode tail){
            ListNode pre=new ListNode(0,tail.next);
            ListNode temp=head;
            while(pre.next!=tail){
                ListNode nextHead=temp.next;
                temp.next=pre.next;
                pre.next=temp;
                temp=nextHead;
            }
            return new ListNode[]{tail,head};
        }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode pre = new ListNode(0, head);
        ListNode temp = pre;
        while (temp.next != null) {
            ListNode tail = temp;
            for (int i = 0; i < k; i++) {
                tail = tail.next;
                if (tail == null) {
                    return pre.next;
                }
            }
            ListNode next = tail.next;
            ListNode[] reverse = reverse(head, tail);
            //重新赋值头尾节点
            head = reverse[0];
            tail = reverse[1];
            temp.next = head;
            tail.next = next;
            temp = tail;
            head = tail.next;
        }
        return pre.next;
    }

    private ListNode[] reverse(ListNode head, ListNode tail) {
        ListNode pre = new ListNode(0, tail.next);
        ListNode temp = head;
        while (pre.next != tail) {
            ListNode next = temp.next;
            temp.next = pre.next;
            pre.next = temp;
            temp = next;
        }
        return new ListNode[]{tail, head};
    }
}
