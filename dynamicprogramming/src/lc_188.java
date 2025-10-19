public class lc_188 {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int lenK = 2 * k + 1;
        int[][] dp = new int[n][lenK];
        for (int i = 1; i <= k; i++) {
            dp[0][2 * i - 1] = -prices[0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < lenK; j++) {
                //偶数，表示第j次的卖出操作
                if (j%2==0){
                    dp[i][j]=Math.max(dp[i-1][j-1]+prices[i],dp[i-1][j]);
                }else {
                    dp[i][j]=Math.max(dp[i-1][j-1]-prices[i],dp[i-1][j]);
                }
            }
        }
        return dp[n-1][2*k];
    }

    /**
     * 状态压缩
     */
    public int maxProfit2(int k, int[] prices) {
        int n = prices.length;
        int lenK = 2 * k + 1;
        int[] dp = new int[lenK];
        for (int i = 1; i <= k; i++) {
            dp[2 * i - 1] = -prices[0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = lenK-1; j >=1; j--) {
                //偶数，表示第j次的卖出操作
                if (j%2==0){
                    dp[j]=Math.max(dp[j-1]+prices[i],dp[j]);
                }else {
                    dp[j]=Math.max(dp[j-1]-prices[i],dp[j]);
                }
            }
        }
        return dp[2*k];
    }
}
