public class lc_70 {
    /**
     * 爬到第n层台阶，可以从(n-2)上两层，也可以从(n-1)上一层
     * 所以递推公式为，dp[n]=dp[n-1]+dp[n2]
     */
    public int climbStairs(int n) {
        if (n==0||n==1){
            return 1;
        }
        int[]arr=new int[n+1];
        arr[0]=1;
        arr[1]=1;
        for (int i=2;i<=n;i++){
            arr[i]=arr[i-1]+arr[i-2];
        }
        return arr[n];
    }
}
