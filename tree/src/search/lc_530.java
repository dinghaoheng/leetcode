package search;

import java.util.ArrayDeque;
import java.util.Deque;

public class lc_530 {
    public int getMinimumDifference(TreeNode root) {
        Integer result = Integer.MAX_VALUE;
        TreeNode pre = null;
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.addFirst(root);
                root = root.left;
            }
            TreeNode node = stack.removeFirst();
            if (pre != null) {
                int diff = node.val - pre.val;
                result = Math.min(result, diff);
            }
            pre = node;
            root = node.right;
        }
        return result;
    }
}
