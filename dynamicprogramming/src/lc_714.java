public class lc_714 {
    public int maxProfit(int[] prices, int fee) {
        int n=prices.length;
        //dp[i][0],持有股票
        //dp[i][1]，不持有股票
        int[][]dp=new int[n][2];
        dp[0][0]=-prices[0];
        for (int i=1;i<n;i++){
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]-prices[i]);
            dp[i][1]=Math.max(dp[i-1][0]+prices[i]-fee,dp[i-1][1]);
        }
        return dp[n-1][1];
    }
}
