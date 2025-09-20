import java.util.ArrayDeque;
import java.util.Deque;

public class lc_513 {
    public int findBottomLeftValue(TreeNode root) {
        int result=0;
        Deque<TreeNode> queue=new ArrayDeque<>();
        queue.addFirst(root);
        while (!queue.isEmpty()){
            int size=queue.size();
            for (int i=0;i<size;i++){
                TreeNode node=queue.removeLast();
                if (i==0&&node.left==null&&node.right==null){
                    result=node.val;
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
