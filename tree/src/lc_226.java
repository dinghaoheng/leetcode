import java.util.ArrayDeque;
import java.util.Deque;

public class lc_226 {
    /**
     * 依次翻转二叉树的所有节点，即可实现翻转的效果
     * 本题采用前序、后序遍历都可
     * 不可采用中序列遍历，因为中节点先交换再进行深度有限遍历，会造成部分节点被遍历两次
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode dummy = root;
        Deque<TreeNode> deque = new ArrayDeque<>();
        while (root != null || !deque.isEmpty()) {
            while (root != null) {
                swap(root);
                deque.addFirst(root);
                root = root.left;
            }
            root = deque.removeFirst();
            root = root.right;
        }
        return dummy;
    }

    private void swap(TreeNode node) {
        if (node == null) {
            return;
        }
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
    }
}
