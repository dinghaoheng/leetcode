public class lc_543 {
    int result=0;
    public int diameterOfBinaryTree(TreeNode root) {
        getDepth(root);
        return result-1;
    }
    private int getDepth(TreeNode root){
        if(root==null){
            return 0;
        }
        int leftDepth=getDepth(root.left);
        int rightDepth=getDepth(root.right);
        result=Math.max(result,(leftDepth+rightDepth+1));
        return Math.max(leftDepth,rightDepth)+1;
    }
}
