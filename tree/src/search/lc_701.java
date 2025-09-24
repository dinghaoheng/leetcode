package search;

public class lc_701 {
    /**
     * 二叉搜索树，总有一个空节点可以插入新节点     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root==null){
            return new TreeNode(val);
        }
        TreeNode current=root;
        TreeNode pre=null;
        while (current!=null){
            pre=current;
            if (current.val>val){
                current=current.left;
            }else {
                current=current.right;
            }
        }
        if (pre.val>val){
            pre.left=new TreeNode(val);
        }else {
            pre.right=new TreeNode(val);
        }
        return root;
    }

    public TreeNode insertIntoBST2(TreeNode root, int val) {
        if (root==null){
            return new TreeNode(val);
        }
        if (root.val>val){
            root.left=insertIntoBST(root.left,val);
        }else {
            root.right=insertIntoBST(root.right,val);
        }
        return root;
    }
}
