public class lc_27 {
    public int removeElement(int[] nums, int val) {
        int l=0;
        int r=0;
        int count=0;
        for (;r<nums.length;r++){
            if (nums[r]!=val){
                swap(nums,l,r);
                l++;
                count++;
            }
        }
        return count;
    }
    private void swap(int[] nums,int a, int b){
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }
}
