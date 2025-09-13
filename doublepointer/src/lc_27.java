public class lc_27 {


    public int removeElement(int[] nums, int val) {
        int slow=0;
        for (int fast=0;fast<nums.length;fast++){
            if (nums[fast]!=val){
                swap(nums,slow,fast);
                slow++;
            }
        }
        return slow;
    }

    /**
     * 若ab相等，需要提前返回
     */
    private void swap(int[] nums,int a,int b){
        if (a==b){
            return;
        }
        nums[a]^=nums[b];
        nums[b]^=nums[a];
        nums[a]^=nums[b];
    }
}
