public class lc_654 {
    int[] nums;
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        this.nums=nums;
        return buildTree(0,nums.length-1);
    }
    private TreeNode buildTree(int start,int end){
        if (start>end){
            return null;
        }
        if (start==end){
            return new TreeNode(nums[start]);
        }
        int max=nums[start];
        int index=start;
        for (int i=start;i<=end;i++){
            if (nums[i]>max){
                max=nums[i];
                index=i;
            }
        }
        TreeNode root=new TreeNode(max);
        root.left=buildTree(start,index-1);
        root.right=buildTree(index+1,end);
        return root;
    }
}
