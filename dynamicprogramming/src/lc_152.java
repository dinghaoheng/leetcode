public class lc_152 {
    public int maxProduct(int[] nums) {
        int n=nums.length;
        long[] min=new long[n];
        long[] max=new long[n];
        min[0]=nums[0];
        max[0]=nums[0];
        //因为存在正负，需要同时记录最大值和最小值
        for(int i=1;i<n;i++){
            min[i]=Math.min(min[i-1]*nums[i],Math.min(max[i-1]*nums[i],nums[i]));
            max[i]=Math.max(min[i-1]*nums[i],Math.max(max[i-1]*nums[i],nums[i]));
        }
        //因为最大值没有办法设置一个阈值，需要二次遍历求出
        int result=(int) max[0];
        for(int i=1;i<n;i++){
            result=Math.max(result,(int) max[i]);
        }
        return result;
    }
}
