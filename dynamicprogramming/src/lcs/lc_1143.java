package lcs;

public class lc_1143 {
    public static void main(String[] args) {
        new lc_1143().longestCommonSubsequence("abcde","ace");
    }
    public int longestCommonSubsequence(String text1, String text2) {
        char[] arr1=text1.toCharArray();
        char[] arr2=text2.toCharArray();
        int m=text1.length();
        int n=text2.length();
        int[][] dp=new int[m+1][n+1];
        for (int i=1;i<=m;i++){
            for (int j=1;j<=n;j++){
                if (arr1[i]==arr2[j]){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
}
