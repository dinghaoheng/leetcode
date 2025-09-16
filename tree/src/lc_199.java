import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class lc_199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        if (root==null){
            return result;
        }
        Deque<TreeNode> queue=new ArrayDeque<>();
        queue.addFirst(root);
        while (!queue.isEmpty()){
            int size=queue.size();
            for (int i=0;i<size;i++){
                TreeNode node = queue.removeLast();
                if (i==size-1){
                    result.add(node.val);
                }
                if (node.left!=null){
                    queue.addFirst(node.left);
                }
                if (node.right!=null){
                    queue.addFirst(node.right);
                }
            }
        }
        return result;
    }
}
