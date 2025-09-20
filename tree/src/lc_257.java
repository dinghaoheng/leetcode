import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class lc_257 {
    List<String> result = new ArrayList<>();

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(5);
        node1.left=node2;
        node1.right=node3;
        node2.right=node4;
        new lc_257().binaryTreePaths3(node1);
    }
    public List<String> binaryTreePaths3(TreeNode root) {
        List<String> result = new ArrayList<>();
        Deque<Object> deque = new ArrayDeque<>();
        deque.addFirst(root);
        deque.addFirst(Integer.toString(root.val));
        while (!deque.isEmpty()) {
            String path=(String) deque.removeFirst();
            TreeNode node=(TreeNode) deque.removeFirst();
            if (node.left==null&&node.right==null){
                result.add(path);
            }
            if (node.left!=null){
                deque.addFirst(node.left);
                deque.addFirst(new StringBuffer(path).append("->").append(node.left.val).toString());
            }
            if (node.right!=null){
                deque.addFirst(node.right);
                deque.addFirst(new StringBuffer(path).append("->").append(node.right.val).toString());
            }
        }
        return result;
    }

    /**
     * bfs
     */
    public List<String> binaryTreePaths2(TreeNode root) {
        List<String> result = new ArrayList<>();
        Deque<TreeNode> stack1 = new ArrayDeque<>();
        Deque<String> stack2 = new ArrayDeque<>();
        stack1.addFirst(root);
        stack2.addFirst(Integer.toString(root.val));
        while (!stack1.isEmpty()) {
            TreeNode node = stack1.removeFirst();
            String path = stack2.removeFirst();
            if (node.left == null && node.right == null) {
                result.add(path);
            }
            if (node.left != null) {
                stack1.addFirst(node.left);
                stack2.addFirst(new StringBuffer(path).append("->").append(node.left.val).toString());
            }
            if (node.right != null) {
                stack1.addFirst(node.right);
                stack2.addFirst(new StringBuffer(path).append("->").append(node.right.val).toString());

            }
        }
        return result;
    }

    public List<String> binaryTreePaths(TreeNode root) {
        getPath(root, "");
        return result;
    }

    private void getPath(TreeNode node, String path) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            result.add(new StringBuilder(path).append(node.val).toString());
            return;
        }
        String temp = new StringBuilder(path).append(node.val).append("->").toString();
        getPath(node.left, temp);
        getPath(node.right, temp);
    }
}
