public class lc_2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node=new ListNode();
        ListNode temp=node;
        boolean one=false;
        while(l1!=null||l2!=null||one){
            int val1=0;
            if(l1!=null){
                val1=l1.val;
                l1=l1.next;
            }
            int val2=0;
            if(l2!=null){
                val2=l2.val;
                l2=l2.next;
            }
            int valPlus=0;
            if(one){
                valPlus=1;
                one=false;
            }
            int sum=val1+val2+valPlus;
            if(sum>=10){
                one=true;
                sum-=10;
            }
            temp.next=new ListNode(sum);
            temp=temp.next;
        }
        return node.next;
    }
}
