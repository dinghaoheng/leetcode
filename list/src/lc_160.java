public class lc_160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode temp1=headA;
        ListNode temp2=headB;
        int len1=0;
        int len2=0;
        while (temp1!=null){
            len1++;
            temp1=temp1.next;
        }
        while (temp2!=null){
            len2++;
            temp2=temp2.next;
        }
        if (len1>len2){
            return getIntersectionNode(headB,headA);
        }
        for (int i=0;i<(len2-len1);i++){
            headB=headB.next;
        }
        while (headA!=null&&headB!=null){
            if (headA==headB){
                return headA;
            }
            headA=headA.next;
            headB=headB.next;
        }
        return null;
    }
}
