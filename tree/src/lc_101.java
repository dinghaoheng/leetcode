import java.util.Deque;
import java.util.LinkedList;

public class lc_101 {
    /**
     * 递归
     */
    public boolean isSymmetric(TreeNode root) {
        if (root==null){
            return true;
        }
        return compare(root.left,root.right);
    }
    private boolean compare(TreeNode left, TreeNode right){
        if (left==null&&right==null){
            return true;
        }
        if (left==null||right==null){
            return false;
        }
        if (left.val!=right.val){
            return false;
        }
        boolean same1=compare(left.left,right.right);
        boolean same2=compare(left.right,right.left);
        return same1&&same2;
    }


    public static void main(String[] args) {
        TreeNode node1=new TreeNode(1);
        TreeNode node2=new TreeNode(1);
        TreeNode node3=new TreeNode(1);
        TreeNode node4=new TreeNode(1);
        TreeNode node5=new TreeNode(1);
        TreeNode node6=new TreeNode(1);
        TreeNode node7=new TreeNode(1);
        node1.left=node2;
        node1.right=node3;
        node2.left=node4;
        node2.right=node5;
        node3.left=node6;
        node3.right=node7;
        lc_101 lc101 = new lc_101();
        lc101.isSymmetric2(node1);
    }

    /**
     * 如果用栈模拟递归，需要使用linkedList实现，因为arrayDequeue不能存入Null
     */
    public boolean isSymmetric2(TreeNode root) {
        if (root==null){
            return true;
        }
        Deque<TreeNode> stack=new LinkedList<>();
        stack.push(root.left);
        stack.push(root.right);
        while (!stack.isEmpty()){
            TreeNode right=stack.pop();
            TreeNode left=stack.pop();
            if (right==null&&left==null){
                continue;
            }
            if (right==null||left==null){
                return false;
            }
            if (right.val!=left.val){
                return false;
            }
            stack.push(left.left);
            stack.push(right.right);
            stack.push(left.right);
            stack.push(right.left);
        }
        return true;
    }


}
