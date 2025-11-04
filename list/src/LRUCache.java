import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(2, 1);
        lruCache.put(1, 1);
        lruCache.put(2, 3);
        lruCache.put(4, 1);
        int i = lruCache.get(1);
        int i1 = lruCache.get(2);
        System.out.println(1);
        System.out.println(1);
    }

    class DLinkedNode {
        int value;
        int key;
        DLinkedNode pre;
        DLinkedNode next;

        public DLinkedNode() {

        }

        public DLinkedNode(int key, int val) {
            this.value = val;
            this.key = key;
        }
    }

    int capacity = 0;
    int size = 0;
    DLinkedNode head;
    DLinkedNode tail;
    Map<Integer, DLinkedNode> cache = new HashMap<>();

    public LRUCache(int capacity) {
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.pre = head;
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        DLinkedNode node = cache.get(key);
        removeNode(node);
        addToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            DLinkedNode node = cache.get(key);
            node.value = value;
            return;
        }
        DLinkedNode node = new DLinkedNode(key, value);
        cache.put(key, node);
        addToHead(node);
        size++;
        if (size > capacity) {
            DLinkedNode last = tail.pre;
            removeNode(last);
            cache.remove(last.key);
            size--;
        }
    }

    private void removeNode(DLinkedNode node) {
        DLinkedNode pre = node.pre;
        DLinkedNode next = node.next;
        pre.next = next;
        next.pre = pre;
    }

    private void addToHead(DLinkedNode node) {
        DLinkedNode next = head.next;
        next.pre = node;
        node.next = next;
        node.pre = head;
        head.next = node;
    }
}
