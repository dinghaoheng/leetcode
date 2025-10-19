public class lc_121 {
    /**
     * 贪心，从左往右依次找到最低价格，和最高差价
     */
    public int maxProfit(int[] prices) {
        int l=Integer.MAX_VALUE;
        int result=Integer.MIN_VALUE;
        for (int r=0;r<prices.length;r++){
            l=Math.min(prices[r],l);
            result=Math.max(result,prices[r]-l);
        }
        return result;
    }

    public int maxProfit2(int[] prices) {
        //dp[i][0]表示第i天持有股票，拥有的最多现金
        //dp[i][1]表示第i天不持有股票，拥有的最多现金
        int[][]dp=new int[prices.length][2];
        dp[0][0]=-prices[0];
        dp[0][1]=0;
        for (int i=1;i<prices.length;i++){
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]-prices[i]);
            dp[i][1]=Math.max(dp[i-1][0]+prices[i],dp[i-1][1]);
        }
        return dp[prices.length-1][1];
    }
}
