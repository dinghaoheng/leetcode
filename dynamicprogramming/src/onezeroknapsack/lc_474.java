package onezeroknapsack;

public class lc_474 {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        int[]zero=new int[strs.length];
        int[]one=new int[strs.length];
        //可以放在后面一个循环中进行
        for (int i=0;i<strs.length;i++){
            zero[i]=getCount(strs[i],'0');
            one[i]=getCount(strs[i],'1');
        }
        for (int i = 0; i < strs.length; i++) {
            for (int j = m; j >=zero[i]; j--) {
                for (int k = n; k >=one[i]; k--) {
                    dp[j][k] = Math.max(dp[j][k],dp[j-zero[i]][k-one[i]]+1);
                }
            }
        }
        return dp[m][n];
    }

    private int getCount(String s,char item){
        int result=0;
        for (char str: s.toCharArray()){
            if (str==item){
                result++;
            }
        }
        return result;
    }
}
