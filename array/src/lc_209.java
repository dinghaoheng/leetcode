public class lc_209 {
//    在满足条件，即sun>=target时，记录结果，并尝试缩小窗口
    public int minSubArrayLen(int target, int[] nums) {
        int result=Integer.MAX_VALUE;
        int l=0;
        int sum=0;
        for (int r=0;r<nums.length;r++){
            sum+=nums[r];
            while (sum>=target){
                int length=r-l+1;
                result=Math.min(result,length);
                sum-=nums[l];
                l++;
            }
        }
        return result==Integer.MAX_VALUE? 0 :result;
    }
}
