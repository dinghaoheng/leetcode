public class lc_53 {
    public static void main(String[] args) {
        new lc_53().maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});
    }

    /**
     * 使用贪心，若前面的项加起来的和大于等于0，则可以继续往后追加元素
     * 若和小于0，则不能追加，因为追加元素不如从头开始
     * 此时将起点换为下一个元素
     */
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int result = Integer.MIN_VALUE;
        int sum = 0;
        for (int item : nums) {
            sum += item;
            result = Math.max(sum, result);
            if (sum < 0) {
                sum = 0;
            }
        }
        return result;
    }

}
