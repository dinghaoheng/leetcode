import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class lc_145 {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result=new LinkedList<>();
        Deque<TreeNode> stack=new ArrayDeque<>();
        //用来标记右节点已经遍历过
        TreeNode pre=null;
        while (root!=null||!stack.isEmpty()){
            while (root!=null){
                stack.addFirst(root);
                root=root.left;
            }
            TreeNode node = stack.removeFirst();
            if (node.right==null||node.right==pre){
                result.add(node.val);
                pre=node;
                //将根节点置为null，防止左节点再次入栈
                root=null;
            }else {
                stack.addFirst(node);
                root=node.right;
            }
        }
        return result;
    }
}
