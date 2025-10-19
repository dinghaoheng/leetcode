package completeknapsack;

import java.util.Arrays;

public class lc_322 {
    public static void main(String[] args) {
        new lc_322().coinChange(new int[]{2}, 3);
    }

    public int coinChange(int[] coins, int amount) {
        int[][]dp=new int[coins.length][amount+1];
        Arrays.fill(dp[0],Integer.MAX_VALUE);
        dp[0][0]=0;
        for (int j=coins[0];j<=amount;j++){
            if (dp[0][j-coins[0]]==Integer.MAX_VALUE){
                dp[0][j]=Integer.MAX_VALUE;
            }else {
                dp[0][j]=Math.min(dp[0][j],dp[0][j-coins[0]]+1);
            }
        }
        for(int i=1;i<coins.length;i++){
            for (int j=0;j<=amount;j++){
                if (j<coins[i]||dp[i][j-coins[i]]==Integer.MAX_VALUE){
                    dp[i][j]=dp[i-1][j];
                }else {
                    dp[i][j]=Math.min(dp[i-1][j],dp[i][j-coins[i]]+1);
                }
            }
        }
        return dp[coins.length-1][amount]==Integer.MAX_VALUE? -1 :dp[coins.length-1][amount];
    }
    public int coinChange2(int[] coins, int amount) {
        int[] dp=new int[amount+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        for(int i=0;i<coins.length;i++){
            for(int j=coins[i];j<amount+1;j++){
                if (dp[j-coins[i]]==Integer.MAX_VALUE){
                    continue;
                }
                dp[j]=Math.min(dp[j],dp[j-coins[i]]+1);
            }
        }
        return dp[amount]==Integer.MAX_VALUE ? -1 :dp[amount];
    }
}
