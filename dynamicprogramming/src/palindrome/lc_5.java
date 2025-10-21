package palindrome;

public class lc_5 {

    public String longestPalindrome(String s) {
        int l=0;
        int r=0;
        int result=0;
        int len=s.length();
        boolean[][] dp=new boolean[len][len];
        for (int i=len-1;i>=0;i--){
            for (int j=i;j<len;j++){
                if (s.charAt(i)==s.charAt(j)){
                    if (j-i<=1){
                        dp[i][j]=true;
                    }else {
                        dp[i][j]=dp[i+1][j-1];
                    }
                    if (j-i+1>result&&dp[i][j]){
                        l=i;
                        r=j;
                        result=j-i+1;
                    }
                }
            }
        }
        return s.substring(l,r+1);
    }
}
