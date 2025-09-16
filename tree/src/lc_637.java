import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class lc_637 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result=new LinkedList<>();
        if (root==null){
            return result;
        }
        Deque<TreeNode> deque=new ArrayDeque<>();
        deque.addFirst(root);
        while (!deque.isEmpty()){
            double sum=0.0;
            int size=deque.size();
            for (int i=0;i<size;i++){
                TreeNode node=deque.removeLast();
                sum+=node.val;
                if (node.left!=null){
                    deque.addFirst(node.left);
                }
                if (node.right!=null){
                    deque.addFirst(node.right);
                }
            }
            result.add(sum/size);
        }
        return result;
    }
}
