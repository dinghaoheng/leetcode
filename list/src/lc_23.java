import java.util.PriorityQueue;

public class lc_23 {

    PriorityQueue<CompareNode> queue=new PriorityQueue<>();
    public ListNode mergeKLists(ListNode[] lists) {
        for(ListNode item : lists){
            if (item==null){
                continue;
            }
            queue.add(new CompareNode(item.val,item));
        }
        ListNode pre=new ListNode();
        ListNode temp=pre;
        while (!queue.isEmpty()){
            CompareNode node = queue.remove();
            temp.next=node.listNode;
            ListNode next=node.listNode.next;
            if (next!=null){
                queue.add(new CompareNode(next.val,next));
            }
            temp=temp.next;
        }
        return pre.next;
    }
    public static class CompareNode implements Comparable<CompareNode>{
        private int value;
        private ListNode listNode;
        @Override
        public int compareTo(CompareNode o) {
            return listNode.val-o.value;
        }
        public CompareNode(){

        }
        public CompareNode(int val,ListNode listNode){
            this.value=val;
            this.listNode=listNode;
        }
    }

    /**
     * 分治，自底向上合并
     * 空间复杂度为o1
     * 时间复杂度为LlogM,m为数组的长度，L为链表的节点个数
     */
    public ListNode mergeKLists2(ListNode[] lists) {
        int n=lists.length;
        if(n==0){
            return null;
        }
        for(int step=1;step<n;step*=2){
            for(int i=0;i<n-step;i+=step*2){
                lists[i]=mergeTwoList(lists[i],lists[i+step]);
            }
        }
        return lists[0];
    }
    private ListNode mergeTwoList(ListNode headA,ListNode headB){
        ListNode dummy=new ListNode();
        ListNode temp=dummy;
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
        }
        if(headB!=null){
            temp.next=headB;
        }
        return dummy.next;
    }
}
