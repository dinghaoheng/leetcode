import java.util.Arrays;

public class lc_1005 {
    public int largestSumAfterKNegations(int[] nums, int k) {
        //排序，负数放前面
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            int item = nums[i];
            if (k > 0 && item < 0) {
                sum = sum - item;
                nums[i]=-item;
                k--;
            } else {
                sum += item;
            }
        }
        //再排序,小的数字放前面
        Arrays.sort(nums);
        if (k % 2 == 1) {
            sum=sum-2*nums[0];
        }
        return sum;
    }

}
