public class lc_148 {
    public static void main(String[] args) {
        ListNode node = ListNode.getNode(new int[]{4, 2, 1, 3});
        System.out.println(1);
        System.out.println(1);
    }


    /**
     * 自顶向下，时间复杂度nLogN,空间复杂度logN，空间复杂度为栈深度开销
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //将一个list分为两部分
        ListNode mid = getMid(head);
        //递归，实现两部分list都有序
        ListNode headA = sortList(mid);
        ListNode headB = sortList(head);
        //将两个有序的list合并成一个完整的list
        return merge(headA, headB);
    }

    /**
     * lc_876，快慢指针获取链表的中间节点
     */
    private ListNode getMid(ListNode head) {
        ListNode pre = head;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            //记录慢指针的前一个节点
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        //断开慢指针的前一个指针
        pre.next = null;
        return slow;
    }

    /**
     * lc_21合并有序链表
     */
    private ListNode merge(ListNode nodeA, ListNode nodeB) {
        ListNode pre = new ListNode();
        ListNode temp = pre;
        while (nodeA != null && nodeB != null) {
            if (nodeA.val > nodeB.val) {
                temp.next = nodeB;
                nodeB = nodeB.next;
            } else {
                temp.next = nodeA;
                nodeA = nodeA.next;
            }
            temp = temp.next;
        }
        if (nodeA != null) {
            temp.next = nodeA;
        } else {
            temp.next = nodeB;
        }
        return pre.next;
    }

    /**
     * 自底向上，时间复杂度为nLogN,空间复杂度为1
     */
    public ListNode sortList2(ListNode head) {
        int length = getLength(head);
        ListNode pre = new ListNode(0, head);
        for (int step = 1; step < length; step *= 2) {
            ListNode dummy = pre;
            ListNode cur = pre.next;
            while (cur != null) {
                ListNode headA=cur;
                ListNode headB=split(headA,step);
                //下一轮的起点
                cur=split(headB,step);
                ListNode[] merge=merge2(headA,headB);
                dummy.next=merge[0];
                dummy=merge[1];
            }
        }
        return pre.next;
    }

    private int getLength(ListNode head) {
        int result = 0;
        while (head != null) {
            result++;
            head = head.next;
        }
        return result;
    }

    //分离head的前step个节点
    //断开step与step+1个节点
    //返回step+1节点作为下一个头结点
    private ListNode split(ListNode head, int step){
        for(int i=0;i<step-1&&head!=null;i++){
            head=head.next;
        }
        if(head==null||head.next==null){
            //此时链表长度不满足step，下一个头结点为null
            return null;
        }
        ListNode next=head.next;
        head.next=null;
        return next;
    }

    private ListNode[] merge2(ListNode headA,ListNode headB){
        ListNode pre=new ListNode();
        ListNode temp=pre;
        while(headA!=null&&headB!=null){
            if(headA.val<headB.val){
                temp.next=headA;
                headA=headA.next;
            }else{
                temp.next=headB;
                headB=headB.next;
            }
            temp=temp.next;
        }
        if(headA!=null){
            temp.next=headA;
        }else{
            temp.next=headB;
        }
        //找到最后一个节点
        while(temp.next!=null){
            temp=temp.next;
        }
        return new ListNode[]{pre.next,temp};
    }
}
