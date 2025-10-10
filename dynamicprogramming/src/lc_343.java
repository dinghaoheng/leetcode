public class lc_343 {
    public int integerBreak(int n) {
        //dp数据含义为数字i得到的最大乘积
        int[] dp=new int[n+1];
        dp[2]=1;
        //从dp[3]开始计算
        for (int i=3;i<=n;i++){
            for (int j=1;j<i;j++){
                //在拆分两个数和拆分多个数之间选择
                int max=Math.max(j*(i-j),j*dp[i-j]);
                dp[i]=Math.max(dp[i],max);
            }
        }
        return dp[n];
    }
}
