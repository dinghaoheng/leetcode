package search;

import java.util.ArrayDeque;
import java.util.Deque;

public class lc_538 {
    public static void main(String[] args) {
        TreeNode node4=new TreeNode(4);
        TreeNode node1=new TreeNode(1);
        TreeNode node6=new TreeNode(6);
        TreeNode node0=new TreeNode(0);
        TreeNode node2=new TreeNode(2);
        TreeNode node5=new TreeNode(5);
        TreeNode node7=new TreeNode(7);
        TreeNode node3=new TreeNode(3);
        TreeNode node8=new TreeNode(8);
        node4.left=node1;
        node4.right=node6;
        node1.left=node0;
        node1.right=node2;
        node2.right=node3;
        node6.left=node5;
        node6.right=node7;
        node7.right=node8;
        new lc_538().convertBST(node4);
    }
    public TreeNode convertBST(TreeNode root) {
        int sum=0;
        TreeNode result=root;
        Deque<TreeNode> stack=new ArrayDeque<>();
        while (root!=null||!stack.isEmpty()){
            while (root!=null){
                stack.addFirst(root);
                root=root.right;
            }
            TreeNode node=stack.removeFirst();
            sum+=node.val;
            node.val=sum;
            root=node.left;
        }
        return result;
    }
}
