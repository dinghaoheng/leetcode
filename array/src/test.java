public class test {
    public static void main(String[] args) {
        generateMatrix(4);
    }

    class MyLinkedList {

        class ListNode{
            int val;
            ListNode next;
            public ListNode(int val){
                this.val=val;
            }
            public ListNode(){

            }
        }

        ListNode head;
        int size;

        public MyLinkedList() {
            this.head=new ListNode();
            size=0;
        }

        public int get(int index) {
            if (index>size){
                return -1;
            }
            ListNode dummy=head;
            for (int i=0;i<=index;i++){
                dummy=dummy.next;
            }
            return dummy.val;
        }

        public void addAtHead(int val) {
            addAtIndex(0);
        }

        public void addAtTail(int val) {
            addAtIndex(size);
        }

        public void addAtIndex(int index, int val) {
            if (index>size||index<0){
                return;
            }
            ListNode newNode=new ListNode(val);
            ListNode dummy=head;
            for (int i=0;i<size;i++){
                dummy=dummy.next;
            }
            newNode.next=dummy.next;
            dummy.next=newNode;
            size++;
        }

        public void deleteAtIndex(int index) {
            if (index>size||index<0){
                return;
            }
            size--;
            ListNode dummy=head;
            for (int i=0;i<size;i++){
                dummy=dummy.next;
            }
            dummy.next=dummy.next.next;
        }
    }
}
