public class lc_123 {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        //dp[i][0]:未购买股票
        //dp[i][1]:购买第一次
        //dp[i][2]:卖出第一次
        //dp[i][3]:购买第二次
        //dp[i][4]:卖出第二次
        int[][] dp=new int[n][5];
        dp[0][1]=-prices[0];
        dp[0][3]=-prices[0];
        for (int i=1;i<n;i++){
            dp[i][0]=dp[i-1][0];
            dp[i][1]= Math.max(dp[i-1][0]-prices[i],dp[i-1][1]);
            dp[i][2]=Math.max(dp[i-1][1]+prices[i],dp[i-1][2]);
            dp[i][3]=Math.max(dp[i-1][2]-prices[i],dp[i-1][3]);
            dp[i][4]=Math.max(dp[i-1][3]+prices[i],dp[i-1][4]);
        }
        return dp[n-1][4];
    }

    /**
     * 状态压缩
     */
    public int maxProfit2(int[] prices) {
        int n=prices.length;
        //dp[i][0]:未购买股票
        //dp[i][1]:购买第一次
        //dp[i][2]:卖出第一次
        //dp[i][3]:购买第二次
        //dp[i][4]:卖出第二次
        int[] dp=new int[5];
        dp[1]=-prices[0];
        dp[3]=-prices[0];
        for (int i=1;i<n;i++){
            dp[4]=Math.max(dp[3]+prices[i],dp[4]);
            dp[3]=Math.max(dp[2]-prices[i],dp[3]);
            dp[2]=Math.max(dp[1]+prices[i],dp[2]);
            dp[1]= Math.max(dp[0]-prices[i],dp[1]);
        }
        return dp[4];
    }
}
