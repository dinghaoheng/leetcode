public class lc_96 {
    public static void main(String[] args) {
        new lc_96().numTrees(3);
    }
    public int numTrees(int n) {
        int[] dp=new int[n+1];
        dp[0]=1;
        for (int i=1;i<=n;i++){
            //遍历不同的头节点情况
            for (int j=1;j<=i;j++){
                //以j为头结点的左子树的数量*以j为头结点的右子树的数量
                dp[i]+=dp[j-1]*dp[i-j];
            }
        }
        return dp[n];
    }
}
