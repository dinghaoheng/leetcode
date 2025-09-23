import order.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class lc_236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        //若左和右都找到了值，那么当前节点就是最近的公共祖先
        if (left != null && right != null) {
            return root;
        }
        if (left == null && right != null) {
            return right;
        }
        if (left != null && right == null) {
            return left;
        }
        return null;
    }

    /**
     * 迭代
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        Deque<TreeNode> stack=new ArrayDeque<>();
        TreeNode pre=null;
        //若在左或者右中发现目标节点，则对当前节点进行标记
        Integer max=Integer.MAX_VALUE;
        while (root!=null||!stack.isEmpty()){
            while (root!=null){
                stack.addFirst(root);
                root=root.left;
            }
            TreeNode node=stack.removeFirst();
            if (node.right==null||node.right==pre){
                //当前节点就是p或者q，且子节点出现目标节点，直接返回
                if (node==p||node==q){
                    if ((node.left!=null&&node.left.val==max)||(node.right!=null&&node.right.val==max)){
                        return node;
                    }
                    node.val=max;
                }
                //满足条件，直接返回
                if ((node.left!=null&&node.left.val==max)&&(node.right!=null&&node.right.val==max)){
                    return node;
                }
                //左右节点出现目标节点，进行标记
                if ((node.left!=null&&node.left.val==max)||(node.right!=null&&node.right.val==max)){
                    node.val=max;
                }
                pre=node;
                root=null;
            }else {
                stack.addFirst(node);
                root=node.right;
            }
        }
        return null;
    }
}
