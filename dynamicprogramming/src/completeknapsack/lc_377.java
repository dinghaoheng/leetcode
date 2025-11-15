package completeknapsack;

public class lc_377 {
    public static void main(String[] args) {
        int i = new lc_377().combinationSum42(new int[]{1, 2, 3}, 4);
        System.out.println(1);
    }
    //不同的顺序视为不同的答案，因此本题求的是不同排列的数量
    //对于dp[j-num[i]]，可以选择五个数中的任意一个，而不是在小于等于这个数的里面做选择
    //所以对于排列，需要先遍历背包，再遍历物品
    public int combinationSum4(int[] nums, int target) {
        int[]dp=new int[target+1];
        dp[0]=1;
        for (int j=0;j<=target;j++){
            for (int i=0;i<nums.length;i++){
                if (nums[i]<=j){
                    dp[j]=dp[j]+dp[j-nums[i]];
                }
            }
        }
        return dp[target];
    }


    public int combinationSum42(int[] nums, int target) {
        int n = nums.length;
        // dp[i][j]: 使用前i个数字，通过排列组成和为j的方式数
        int[][] dp = new int[n + 1][target + 1];

        // 初始化：和为0只有1种方式
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int j = 1; j <= target; j++) {
            for (int i = 1; i <= n; i++) {
                dp[i][j] = dp[i - 1][j];  // 不使用nums[i-1]
                if (j >= nums[i - 1]) {
                    dp[i][j] += dp[n][j - nums[i - 1]];  // 使用nums[i-1]，注意这里用dp[n]
                }
            }
        }

        return dp[n][target];
    }
}
