public class lc_707 {
    class MyLinkedList {
        class ListNode {
            int val;
            ListNode next;

            public ListNode(int val) {
                this.val = val;
            }
            public ListNode() {

            }
        }

        ListNode head;
        int size;

        public MyLinkedList() {
            this.head = new ListNode();
            size = 0;
        }

        public int get(int index) {
            if (index < 0 || index >= size) {
                return -1;
            }
            ListNode dummy = head;
            for (int i = 0; i <= index; i++) {
                dummy = dummy.next;
            }
            return dummy.val;
        }

        public void addAtHead(int val) {
            addAtIndex(0, val);
        }

        public void addAtTail(int val) {
            addAtIndex(size, val);
        }

        public void addAtIndex(int index, int val) {
            if (index > size) {
                return;
            }
            size++;
            ListNode node = new ListNode(val);
            //注意小于零的判断
            if (index < 0) {
                node.next = head.next;
                head.next = node;
                return;
            }
            ListNode temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            node.next = temp.next;
            temp.next = node;
        }

        public void deleteAtIndex(int index) {
            if (index < 0 || index >= size) {
                return;
            }
            size--;
            ListNode temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
        }
    }
}
