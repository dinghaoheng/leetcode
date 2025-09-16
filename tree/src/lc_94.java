import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class lc_94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result= new LinkedList<>();
        Deque<TreeNode> stack=new ArrayDeque<>();
        while (root!=null||!stack.isEmpty()){
            while (root!=null){
                stack.addFirst(root);
                root=root.left;
            }
            root=stack.removeFirst();
            result.add(root.val);
            root=root.right;
        }
        return result;
    }
}
