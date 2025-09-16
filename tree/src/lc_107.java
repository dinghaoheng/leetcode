import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class lc_107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        if (root==null){
            return result;
        }
        Deque<TreeNode> queue=new ArrayDeque<>();
        queue.addFirst(root);
        while (!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int size=queue.size();
            for (int i=0;i<size;i++){
                TreeNode node = queue.removeLast();
                list.add(node.val);
                if (node.left!=null){
                    queue.addFirst(node.left);
                }
                if (node.right!=null){
                    queue.addFirst(node.right);
                }
            }
            result.add(0,list);
        }
        return result;
    }
}
