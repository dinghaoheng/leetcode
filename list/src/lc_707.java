public class lc_707 {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(1);
        myLinkedList.addAtTail(3);
        myLinkedList.addAtIndex(1, 2);
        myLinkedList.get(1);
        myLinkedList.deleteAtIndex(1);
        myLinkedList.get(1);
        System.out.println(1);
        System.out.println(1);
    }

    static class MyLinkedList {
        class ListNode {
            int val;
            ListNode next;

            public ListNode(int val) {
                this.val = val;
            }

            public ListNode() {

            }
        }

        private int size = 0;
        private ListNode head = new ListNode();

        public MyLinkedList() {
            ListNode node = new ListNode();
            head.next = node;
        }

        public int get(int index) {
            if (index < 0 || index >= size) {
                return -1;
            }
            ListNode dummy = head;
            for (int i = 0; i < index; i++) {
                dummy = dummy.next;
            }
            return dummy.next.val;
        }

        public void addAtHead(int val) {
            addAtIndex(0, val);
        }

        public void addAtTail(int val) {
            addAtIndex(size, val);
        }

        public void addAtIndex(int index, int val) {
            if (index < 0 || index > size) {
                return;
            }
            ListNode node = new ListNode(val);
            size++;
            ListNode dummy = head;
            for (int i = 0; i < index; i++) {
                dummy = dummy.next;
            }
            node.next = dummy.next;
            dummy.next = node;
        }

        public void deleteAtIndex(int index) {
            if (index < 0 || index >= size) {
                return;
            }
            size--;
            ListNode dummy = head;
            for (int i = 0; i < index; i++) {
                dummy = dummy.next;
            }
            dummy.next = dummy.next.next;
        }
    }
}
