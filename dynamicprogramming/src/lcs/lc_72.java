package lcs;

public class lc_72 {
    public int minDistance(String word1, String word2) {
        int m=word1.length();
        int n=word2.length();
        int[][] dp=new int[m+1][n+1];
        for (int i=0;i<=m;i++){
            dp[i][0]=i;
        }
        for (int i=0;i<=n;i++){
            dp[0][i]=i;
        }
        for (int i=1;i<=m;i++){
            for (int j=1;j<=n;j++){
                if (word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }else {
                    //1.word1删除，则结果为dp[i-1][j]+1
                    //2.word2删除，则结果为dp[i][j-1]+1
                    //3.word1或者2更新，则结果为dp[i-1][j-1]+1
                    int min=Math.min(dp[i-1][j],dp[i][j-1]);
                    dp[i][j]=Math.min(dp[i-1][j-1],min)+1;
                }
            }
        }
        return dp[m][n];
    }
}
