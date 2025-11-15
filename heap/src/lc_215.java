import java.util.Random;

public class lc_215 {
    private final Random random = new Random();

    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        int target = n - k;
        int l = 0;
        int r = n - 1;
        while (true) {
            int idx = partation(nums, l, r);
            if (idx == target) {
                return nums[idx];
            } else if (idx > target) {
                r = idx - 1;
            } else {
                l = idx + 1;
            }
        }
    }

    private int partation(int[] nums, int l, int r) {
        int idx = l + random.nextInt(r - l + 1);
        int pivot = nums[idx];
        swap(nums, idx, l);

        int i = l + 1;
        int j = r;

        while (true) {
            //需要满足nums[i]>=pivot
            while (i <= j && nums[i] < pivot) {
                i++;
            }
            //需要满足nums[j]>=pivot
            //这样做的目的是保证有大量相同的元素的时候，可以返回中间位置，避免复杂度退化
            while (i <= j && nums[j] > pivot) {
                j--;
            }
            if(i>=j){
                break;
            }
            swap(nums,i,j);
            i++;
            j--;
        }
        swap(nums, l, j);
        return j;

    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
