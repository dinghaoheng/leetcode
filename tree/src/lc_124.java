public class lc_124 {
    int result = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return result;
    }

    /**
     * 获取以当前节点为根节点，向左或者向右可以得到的最大链
     */
    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        result = Math.max(result, left + right + root.val);
        return Math.max(Math.max(left, right) + root.val, 0);
    }
}
