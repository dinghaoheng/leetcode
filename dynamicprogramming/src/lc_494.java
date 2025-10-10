import java.util.Arrays;

public class lc_494 {
    public static void main(String[] args) {
     }
    public int findTargetSumWays(int[] nums, int target) {
        //将数组分为两部分，l和r，l都用减号，r都用加号
        //l+r=sum,r-l=target，所以得到，r=(sum+target)/2
        //这题可以转换成，求装满容量为r的背包的方法数
        int sum= Arrays.stream(nums).sum();
        int sumPlus=sum+target;
        if (sumPlus%2!=0){
            return 0;
        }
        if (Math.abs(target)>sum){
            return 0;
        }
        int x=sumPlus/2;
        int[]dp=new int[x+1];
        dp[0]=1;
        for (int i=0;i<nums.length;i++){
            for (int j=x;j>=nums[i];j--){
                dp[j]=dp[j]+dp[j-nums[i]];
            }
        }
        return dp[x];
    }
}
