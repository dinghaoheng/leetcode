package onezeroknapsack;

public class lc_1049 {
    public static void main(String[] args) {
        new lc_1049().lastStoneWeightII(new int[]{2,4,1,1});
    }
    public int lastStoneWeightII(int[] stones) {
        int sum=0;
        for (int item : stones){
            sum+=item;
        }
        int target=sum/2;
        int[] dp=new int[target+1];
        for (int i = stones[0];i<=target;i++){
            dp[i]=stones[0];
        }
        for (int i=1;i<stones.length;i++){
            for (int j=target;j>=stones[i];j--){
                dp[j]=Math.max(dp[j],dp[j-stones[i]]+stones[i]);
            }
        }
        //由于向下取整，所以(sum-dp[target])>=dp[target]
        return sum-dp[target]-dp[target];
    }
}
