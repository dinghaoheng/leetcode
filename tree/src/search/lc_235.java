package search;

import java.util.ArrayDeque;
import java.util.Deque;

public class lc_235 {
    /**
     * 从根节点开始，找到的第一个值在p和q之间的节点，就是最近的公共祖先
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Deque<TreeNode> stack=new ArrayDeque<>();
        Integer min=Math.min(p.val,q.val);
        Integer max=Math.max(p.val,q.val);
        while (root!=null){
            if (root.val>max){
                root=root.left;
            }else if (root.val<min){
                root=root.right;
            }
            return root;
        }
        return null;
    }
}
