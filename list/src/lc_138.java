public class lc_138 {
    public Node copyRandomList(Node head) {
        if(head==null){
            return null;
        }
        //构建新的节点
        Node temp1=head;
        while(temp1!=null){
            Node newNode=new Node(temp1.val);
            newNode.next=temp1.next;
            temp1.next=newNode;
            temp1=temp1.next.next;
        }
        //构建random指针
        Node temp2=head;
        while(temp2!=null){
            if(temp2.random!=null){
                temp2.next.random=temp2.random.next;
            }
            temp2=temp2.next.next;
        }
        //分离两个链表，并且复原旧链表
        Node oldHead=head;
        Node newHead=head.next;
        while(oldHead!=null&&oldHead.next.next!=null){
            Node nextOld=oldHead.next.next;
            Node nextNew=nextOld.next;
            //链接新链表
            oldHead.next.next=nextNew;
            //复原旧链表
            oldHead.next=nextOld;
            oldHead=nextOld;
        }
        //最后一步，需要恢复原链表的下一个节点为空
        oldHead.next=null;
        return newHead;
    }
}
