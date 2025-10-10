public class lc_416 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int item : nums) {
            sum += item;
        }
        if (sum % 2 != 0) {
            return false;
        }
        sum /= 2;
        int n = nums.length;
        //dp[i][j]的含义为，容量上限为i背包，用前j个数字，可以得到的和最大为多少
        //若和恰好为目标数字sum，则返回true
        int[][] dp = new int[n][sum + 1];
        for (int j = nums[0]; j <= sum; j++) {
            dp[0][j] = nums[0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (j < nums[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - nums[i]] + nums[i]);
                }
            }
            if (dp[i][sum] == sum) {
                return true;
            }
        }
        return dp[n - 1][sum] == sum;
    }

    public static void main(String[] args) {
        new lc_416().canPartition2(new int[]{1, 5, 11, 5});
    }

    public boolean canPartition2(int[] nums) {
        int sum = 0;
        for (int item : nums) {
            sum += item;
        }
        if (sum % 2 != 0) {
            return false;
        }
        sum /= 2;
        int n = nums.length;
        //dp[i][j]的含义为，容量上限为i背包，用前j个数字，可以得到的和最大为多少
        //若和恰好为目标数字sum，则返回true
        int[] dp = new int[sum + 1];
        for (int i = nums[0]; i <= sum; i++) {
            dp[i] = nums[0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = sum; j >= 0; j--) {
                if (j >= nums[i]) {
                    dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
                }
            }
            if (dp[sum] == sum) {
                return true;
            }
        }
        return dp[sum] == sum;
    }

    public boolean canPartition3(int[] nums) {
        int sum = 0;
        for (int item : nums) {
            sum += item;
        }
        if (sum % 2 != 0) {
            return false;
        }
        sum /= 2;
        int n = nums.length;
        //dp[i][j]的含义为，容量上限为i背包，用前j个数字，是否可以达到sum
        boolean[][] dp = new boolean[n][sum + 1];
        for (int j = nums[0]; j <= sum; j++) {
            dp[0][j] = nums[0] == j;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (j < nums[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
            }
            if (dp[i][sum]) {
                return true;
            }
        }
        return dp[n - 1][sum];
    }
}
