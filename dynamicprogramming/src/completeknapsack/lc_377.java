package completeknapsack;

public class lc_377 {
    public static void main(String[] args) {
        int i = new lc_377().combinationSum4(new int[]{1, 2, 3}, 4);
        System.out.println(1);
    }
    //不同的顺序视为不同的答案，因此本题求的是不同排列的数量
    //对于dp[j-num[i]]，可以选择五个数中的任意一个，而不是在小于等于这个数的里面做选择
    //所以对于排列，需要先遍历背包，再遍历物品
    public int combinationSum4(int[] nums, int target) {
        int[]dp=new int[target+1];
        dp[0]=1;
        for (int j=0;j<=target;j++){
            for (int i=0;i<nums.length;i++){
                if (nums[i]<=j){
                    dp[j]=dp[j]+dp[j-nums[i]];
                }
            }
        }
        return dp[target];
    }
}
