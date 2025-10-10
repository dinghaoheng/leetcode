public class lc_283 {
    public void moveZeroes(int[] nums) {
        int l=0;
        int r=0;
        for (;r<nums.length;r++){
            if (nums[r]!=0){
                swap(nums,l,r);
                l++;
            }
        }
    }
    private void swap(int[] nums,int a,int b){
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }
}
