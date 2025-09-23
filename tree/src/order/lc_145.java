package order;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class lc_145 {

    public static void main(String[] args) {
        TreeNode node1=new TreeNode(1);
        TreeNode node2=new TreeNode(2);
        TreeNode node3=new TreeNode(3);
        TreeNode node4=new TreeNode(4);
        TreeNode node5=new TreeNode(5);
        TreeNode node6=new TreeNode(6);
        TreeNode node7=new TreeNode(7);
        TreeNode node8=new TreeNode(8);
        TreeNode node9=new TreeNode(9);
        node1.left=node2;
        node1.right=node3;
        node2.left=node4;
        node2.right=node5;
        node5.left=node6;
        node5.right=node7;
        node3.right=node8;
        node8.left=node9;
        new lc_145().postorderTraversal(node1);
    }

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
