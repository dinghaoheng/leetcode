
public class lc_337 {
    public int rob(TreeNode root) {
        if (root==null){
            return 0;
        }
        int[] result=robAction(root);
        return Math.max(result[0],result[1]);
    }
    private int[] robAction(TreeNode root){
        //0是不选，1是选
        int[] res = new int[2];
        if (root == null) {
            return res;
        }
        int[] left=robAction(root.left);
        int[] right=robAction(root.right);
        int val1=Math.max(left[0],left[1])+Math.max(right[0],right[1]);
        int val2=root.val+left[0]+right[0];
        res[0]=val1;
        res[1]=val2;
        return res;
    }
}
