package lcs;

public class lc_53 {
    /**
     * dp[i]有两个途径，加入前面的数组，或者成为新的数组，二者取较大值
     */
    public int maxSubArray(int[] nums) {
        int[] dp=new int[nums.length];
        dp[0]=nums[0];
        int res=nums[0];
        for (int i=1;i<nums.length;i++){
            dp[i]=Math.max(dp[i-1]+nums[i],nums[i]);
            res=Math.max(res,dp[i]);
        }
        return res;
    }
}
