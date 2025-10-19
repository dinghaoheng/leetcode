package completeknapsack;

import java.util.Arrays;

public class lc_279 {
    public int numSquares(int n) {
        int[]dp=new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        for (int j=0;j<=n;j++){
            for (int i=1;i*i<=j;i++){
                int sqr=i*i;
                if (j<sqr||dp[j-sqr]==Integer.MAX_VALUE){
                    continue;
                }
                dp[j]=Math.min(dp[j],dp[j-sqr]+1);
            }
        }
        return dp[n];
    }
}
