package search;

public class lc_450 {
    /**
     * 找到目标节点之后
     * 1.若左右节点都为空，删除当前节点
     * 2.只有左节点为空，返回右节点
     * 3.只有右节点为空，返回左节点
     * 4.左右都不为空，将左节点移动到右节点的最左孩子节点上，然后返回右节点
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            if (root.left == null && root.right == null) {
                return null;
            }
            if (root.left == null && root.right != null) {
                return root.right;
            }
            if (root.right == null && root.left != null) {
                return root.left;
            }
            TreeNode node = root.right;
            while (node.left != null) {
                node = node.left;
            }
            node.left = root.left;
            return root.right;
        }
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(6);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.right = node6;
        new lc_450().deleteNode2(node1, 3);
    }

    public TreeNode deleteNode2(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        TreeNode cur = root;
        TreeNode pre = null;
        while (cur != null && cur.val != key) {
            pre = cur;
            if (cur.val > key) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        if (pre == null) {
            return deleteNode(cur);
        }
        if (cur == null) {
            return root;
        }
        if (pre.left == cur) {
            pre.left = deleteNode(pre.left);
        }
        if (pre.right == cur) {
            pre.right = deleteNode(pre.right);
        }
        return root;
    }

    private TreeNode deleteNode(TreeNode node) {
        if (node == null) {
            return null;
        }
        if (node.right == null && node.left == null) {
            return null;
        }
        if (node.left == null) {
            return node.right;
        }
        if (node.right == null) {
            return node.left;
        }
        TreeNode temp = node.right;
        while (temp.left != null) {
            temp = temp.left;
        }
        temp.left = node.left;
        return node.right;
    }
}
