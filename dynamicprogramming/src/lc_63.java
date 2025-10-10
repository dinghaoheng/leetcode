public class lc_63 {
    public static void main(String[] args) {
        int[]arr1=new int[0];
        int[]arr2=new int[1];
        new lc_63().uniquePathsWithObstacles(new int[][]{arr1,arr2});
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int[]dp=new int[n];
        for (int i=0;i<n;i++){
            if (obstacleGrid[0][i]==1){
                break;
            }
            dp[i]=1;
        }
        for (int i=1;i<m;i++){
            for (int j=0;j<n;j++){
                if (obstacleGrid[i][j]==1){
                    dp[j]=0;
                    continue;
                }
                if (j!=0){
                    dp[j]=dp[j]+dp[j-1];
                }
            }
        }
        return dp[n-1];
    }
}
