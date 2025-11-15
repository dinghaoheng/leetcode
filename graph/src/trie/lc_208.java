package trie;

public class lc_208 {
    public static class Node {
        Node[] node = new Node[26];
        boolean isEnd = false;
    }

    private final Node root = new Node();

    public void insert(String word) {
        Node cur = root;
        for (char item : word.toCharArray()) {
            int idx = item - 'a';
            if (cur.node[idx] == null) {
                cur.node[idx] = new Node();
            }
            cur = cur.node[idx];
        }
        cur.isEnd = true;
    }

    public boolean search(String word) {
        return find(word) == 2;
    }

    public boolean startsWith(String prefix) {
        return find(prefix) != 0;
    }

    private int find(String str) {
        Node cur = root;
        for (char item : str.toCharArray()) {
            int idx = item - 'a';
            if (cur.node[idx] == null) {
                return 0;
            }
            cur = cur.node[idx];
        }
        return cur.isEnd ? 2 : 1;
    }
}
