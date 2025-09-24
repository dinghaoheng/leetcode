package search;

public class lc_669 {
    public TreeNode trimBST2(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
        if (root.val < low) {
            return trimBST(root.right, low, high);
        }
        if (root.val > high) {
            return trimBST(root.left, low, high);
        }
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }

    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
        //先修剪根节点
        while (root != null && (root.val < low || root.val > high)) {
            if (root.val < low) {
                root = root.right;
            }
            if (root.val > high) {
                root = root.left;
            }
        }
        TreeNode cur = root;
        //修剪左子树
        //当左节点小于val，将左节点的左节点舍弃，左节点替换为左节点的右节点
        while (cur != null) {
            while (cur.left != null && cur.left.val < low) {
                cur.left = cur.left.right;
            }
            cur = cur.left;
        }
        cur = root;
        while (cur != null) {
            while (cur.right != null && cur.right.val > high) {
                cur.right = cur.right.left;
            }
            cur = cur.right;
        }
        return root;
    }
}
