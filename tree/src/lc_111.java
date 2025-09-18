import java.util.ArrayDeque;
import java.util.Deque;

public class lc_111 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int result = 0;
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.addFirst(root);
        while (!stack.isEmpty()) {
            int size = stack.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = stack.removeLast();
                if (node.left == null && node.right == null) {
                    return result;
                }
                if (node.left != null) {
                    stack.addFirst(node.left);
                }
                if (node.right != null) {
                    stack.addFirst(node.right);
                }
            }
        }
        return result;
    }
}
