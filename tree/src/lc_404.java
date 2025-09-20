import java.util.ArrayDeque;
import java.util.Deque;

public class lc_404 {
    public int sumOfLeftLeaves(TreeNode root) {
        int sum=0;
        if (root==null){
            return 0;
        }
        Deque<TreeNode> queue=new ArrayDeque<>();
        queue.addFirst(root);
        while (!queue.isEmpty()){
            int size=queue.size();
            for (int i=0;i<size;i++){
                TreeNode node=queue.removeLast();
                //这里不能取第一个节点，可能取到右边的节点，需要判断node.left,
                if (node.left!=null&&node.left.left==null&&node.left.right==null){
                    sum+=node.left.val;
                }
                if (node.left!=null){
                    queue.addFirst(node.left);
                }
                if (node.right!=null){
                    queue.addFirst(node.right);
                }
            }
        }
        return sum;
    }
}
