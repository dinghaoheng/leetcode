public class lc_75 {
    public void sortColors(int[] nums) {
        int red = 0;
        int blue = nums.length - 1;
        int white = 0;
        while (white <= blue) {
            //如果和左边的数做交换，不用再次判断，因为数组左边的数已经遍历过了
            if (nums[white] == 0) {
                swap(nums, red, white);
                red++;
                white++;
            } else if (nums[white] == 2) {
                //如果和右边的数做交换，需要二次判断，因为右边的数还没有遍历
                swap(nums, blue, white);
                blue--;
            } else {
                white++;
            }
        }
    }

    private void swap(int[] nums, int a, int b) {
        if (a == b) {
            return;
        }
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
