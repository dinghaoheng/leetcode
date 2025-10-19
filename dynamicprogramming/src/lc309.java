public class lc309 {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        //dp[i][0]，持有股票
        //dp[i][1]，不持有股票，且不处于冷近期
        //dp[i][2]，不持有股票，且处于冷近期
        int[][] dp=new int[n][3];
        dp[0][0]=-prices[0];
        for (int i=1;i<n;i++){
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]-prices[i]);
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][2]);
            dp[i][2]=dp[i-1][0]+prices[i];
        }
        return Math.max(dp[n-1][1],dp[n-1][2]);
    }
}
