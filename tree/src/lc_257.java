import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class lc_257 {
    List<String> result = new ArrayList<>();

    /**
     * bfs
     */
    public List<String> binaryTreePaths2(TreeNode root) {
        List<String> result=new ArrayList<>();
        Deque<TreeNode> stack1=new ArrayDeque<>();
        Deque<String> stack2=new ArrayDeque<>();
        stack1.addFirst(root);
        stack2.addFirst(Integer.toString(root.val));
        while (!stack1.isEmpty()){
            TreeNode node=stack1.removeFirst();
            String path=stack2.removeFirst();
            if (node.left==null&&node.right==null){
                result.add(path);
            }
            if (node.left!=null){
                stack1.addFirst(node.left);
                stack2.addFirst(new StringBuffer(path) .append("->") .append(node.left.val).toString());
            }
            if (node.right!=null){
                stack1.addFirst(node.right);
                stack2.addFirst(new StringBuffer(path) .append("->") .append(node.right.val).toString());

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
