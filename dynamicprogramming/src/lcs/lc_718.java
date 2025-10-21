package lcs;

public class lc_718 {
    public static void main(String[] args) {
        int[] num1=new int[]{1,2,3,2,8};
        int[] num2=new int[]{5,6,1,4,7};
        new lc_718().findLength(num1,num2);
    }
    public int findLength(int[] nums1, int[] nums2) {
        int m=nums1.length;
        int n=nums2.length;
        int[][] dp=new int[m][n];
        int result=0;
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (i==0||j==0){
                    dp[i][j]=nums1[i]==nums2[j] ? 1:0;
                }else if (nums1[i]==nums2[j]){
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                result=Math.max(result,dp[i][j]);
            }
        }
        return result;
    }
}
