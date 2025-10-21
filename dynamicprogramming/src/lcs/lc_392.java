package lcs;

public class lc_392 {
    /**
     * 与1143，最长公共子序列相同
     */
    public boolean isSubsequence(String s, String t) {
        char[] arr1=s.toCharArray();
        char[] arr2=t.toCharArray();
        int[][] dp=new int[s.length()+1][t.length()+1];
        for (int i=1;i<=s.length();i++){
            for (int j=1;j<=t.length();j++){
                if (arr1[i-1]==arr2[j-1]){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[s.length()][t.length()]==s.length();
    }

    public static void main(String[] args) {
        boolean ahbgdc = new lc_392().isSubsequence("", "ahbgdc");
        System.out.println(1);
        System.out.println(1);
    }

    /**
     * 双指针
     */
    public boolean isSubsequence2(String s, String t) {
        int i=0;
        for (int j=0;j<t.length();j++){
            if (i<s.length()&&t.charAt(j)==s.charAt(i)){
                i++;
            }
        }
        return i==s.length();
    }
}
