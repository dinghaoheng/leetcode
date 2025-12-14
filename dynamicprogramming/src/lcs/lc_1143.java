package lcs;

public class lc_1143 {
    public static void main(String[] args) {
        new lc_1143().longestCommonSubsequence("abcde","ace");
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int m=text1.length();
        int n=text2.length();
        char [] arr1=text1.toCharArray();
        char [] arr2=text2.toCharArray();
        //dp[i][j]，以i-1，j-1结尾的字符串，最长公共子序列是长
        //使用i-1和j-1是为了避免初始化数值的麻烦
        int[][] dp=new int[m+1][n+1];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                //如果两个字符相同，直接在前一个长度上+1
                if(arr1[i-1]==arr2[j-1]){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    //如果两个字符不同，需要选择抛弃一个尾部字符
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
}
