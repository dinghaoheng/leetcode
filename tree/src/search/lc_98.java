package search;

import java.util.ArrayDeque;
import java.util.Deque;

public class lc_98 {
    public boolean isValidBST(TreeNode root) {
        TreeNode pre=null;
        Deque<TreeNode> stack=new ArrayDeque<>();
        while (root!=null||!stack.isEmpty()){
            while (root!=null){
                stack.addFirst(root);
                root=root.left;
            }
            TreeNode node=stack.removeFirst();
            if (pre!=null&&node.val<=pre.val){
                return false;
            }
            pre=node;
            root=node.right;
        }
        return true;
    }
}
