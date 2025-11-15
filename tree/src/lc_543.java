public class lc_543 {
    int[][] direct=new int[][]{{0,1}};
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

    public static void main(String[] args) {
        TreeNode node1=new TreeNode(1);
        TreeNode node2=new TreeNode(2);
        TreeNode node3=new TreeNode(3);
        TreeNode node4=new TreeNode(4);
        TreeNode node5=new TreeNode(5);
        node1.left=node2;
        node1.right=node3;
        node2.left=node4;
        node2.right=node5;
        new lc_543().diameterOfBinaryTree2(node1);
    }
    public int diameterOfBinaryTree2(TreeNode root) {
        dfs(root);
        return result;
    }
    private int dfs(TreeNode node){
        if(node==null){
            return 0;
        }
        int left=dfs(node.left)+1;
        int right=dfs(node.right)+1;
        result=Math.max(result,left+right);
        return Math.max(left,right);
    }
}
