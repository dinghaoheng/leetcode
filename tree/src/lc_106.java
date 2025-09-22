import java.util.Map;

public class lc_106 {
    int[] inorder;
    int[] postorder;
    Map<Integer, Integer> map;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postorder = postorder;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(0,inorder.length-1,0,postorder.length-1);
    }



    private TreeNode buildTree(int inStart, int inEnd, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postEnd]);
        Integer rootIndex = map.get(postorder[postEnd]);
        Integer leftCount = rootIndex - inStart;
        root.left = buildTree(inStart, rootIndex - 1, postStart, postStart + leftCount - 1);
        root.right = buildTree(rootIndex + 1, inEnd, postStart + leftCount, postEnd - 1);
        return root;
    }
}
