public class lc_26 {
    public int removeDuplicates(int[] nums) {
        int l=1;
        int r=1;
        for (;r<nums.length;r++){
            if (nums[r]!=nums[r-1]){
                nums[l]=nums[r];
                l++;
            }
        }
        return l;
    }
}
