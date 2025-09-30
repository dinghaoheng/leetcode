public class lc_122 {
    /**
     * 无论是间隔多少天的收益，都可以拆分成相邻日期的利润
     * 所以只要手机相邻日期的利润且为正式的，然后求和
     */
    public int maxProfit(int[] prices) {
        if (prices.length<=1){
            return 0;
        }
        int result=0;
        for (int i=1;i<prices.length;i++){
            int diff=prices[i]-prices[i-1];
            if (diff>0){
                result+=diff;
            }
        }
        return result;
    }
}
