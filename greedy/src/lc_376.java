public class lc_376 {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        //在数组的前面防止一个和nums[0]一样的数字
        int preDiff = 0;
        int currDiff = 0;
        int result = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            currDiff = nums[i + 1] - nums[i];
            if ((preDiff <= 0 && currDiff > 0) || (preDiff >= 0 && currDiff < 0)) {
                result++;
                preDiff = currDiff;
            }
        }
        return result;
    }
}
