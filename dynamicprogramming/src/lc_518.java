public class lc_518 {
    public static void main(String[] args) {
        int change = new lc_518().change(5, new int[]{1, 2, 3});
        System.out.println(1);
    }
    public int change(int amount, int[] coins) {
        int count=coins.length;
        int[][]dp=new int[count][amount+1];
        for (int i=0;i<coins.length;i++){
            dp[i][0]=1;
        }
        for (int j=coins[0];j<=amount;j++){
            if (j%coins[0]==0){
                dp[0][j]=1;
            }
        }
        for (int i=1;i<count;i++){
            for (int j=0;j<=amount;j++){
                if (j<coins[i]){
                    dp[i][j]=dp[i-1][j];
                }else {
                    dp[i][j]=dp[i-1][j]+dp[i][j-coins[i]];
                }
            }
        }
        return dp[count-1][amount];
    }

    public int change3(int amount, int[] coins) {
        int count=coins.length;
        int[][]dp=new int[count][amount+1];
        for (int i=0;i<coins.length;i++){
            dp[i][0]=1;
        }
        for (int j=coins[0];j<=amount;j++){
            if (j%coins[0]==0){
                dp[0][j]=1;
            }
        }
        for (int j=0;j<=amount;j++){
            for (int i=1;i<count;i++){
                if (j<coins[i]){
                    dp[i][j]=dp[i-1][j];
                }else {
                    dp[i][j]=dp[i-1][j]+dp[i][j-coins[i]];
                }
            }
        }
        return dp[count-1][amount];
    }

    public int change1(int amount, int[] coins) {
        int count=coins.length;
        int[]dp=new int[amount+1];
        dp[0]=1;
        for (int i=0;i<count;i++){
            for (int j=coins[i];j<=amount;j++){
                dp[j]=dp[j]+dp[j-coins[i]];
            }
        }
        return dp[amount];
    }
}
