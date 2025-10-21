package lcs;

public class lc_115 {
    public int numDistinct(String s, String t) {
        int m=s.length();
        int n=t.length();
        int[][] dp=new int[m+1][n+1];
        //当t为空串时，无论s多长，都只包含一个t
        //当s为空串时，只有在t也为空串，数量才为1，否则为0
        for (int i=0;i<=m;i++){
            dp[i][0]=1;
        }
        for (int i=1;i<=m;i++){
            for (int j=1;j<=n;j++){
                //若当前字符相等，有两个选项
                //用当前字符，那么dp[i][j]=dp[i-1][j-1]，因为可以完全不考虑该字符
                //不用当前字符，那么dp[i][j]=dp[i-1][j]
                if (s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
                }else {
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[m][n];
    }
}
