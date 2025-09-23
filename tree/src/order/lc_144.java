package order;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class lc_144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result= new LinkedList<>();
        if (root==null){
            return null;
        }
        Deque<TreeNode> stack=new ArrayDeque<>();
        while (root!=null||!stack.isEmpty()){
            while (root!=null){
                result.add(root.val);
                stack.addFirst(root);
                root=root.left;
            }
            root=stack.removeFirst();
            root=root.right;
        }
        return result;
    }

    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> result=new LinkedList<>();
        preOrder(root,result);
        return result;
    }

    private void preOrder (TreeNode node, List<Integer> result){
        if (node==null){
            return;
        }
        result.add(node.val);
        preOrder(node.left,result);
        preOrder(node.right,result);
    }
}
