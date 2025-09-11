import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc_18 {
    public static void main(String[] args) {
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        for (int a = 0; a < len; a++) {
            if (nums[a]>0&& nums[a] > target) {
                break;
            }
            if (a > 0 && nums[a] == nums[a - 1]) {
                continue;
            }
            for (int b = a + 1; b < len; b++) {
                //这里需要判断a和b的和大于target，因为只有b大于，可能a和b的和是不大于b的
                if (nums[b]>0&& nums[a]+nums[b]> target) {
                    break;
                }
                if (b !=a+1 && nums[b] == nums[b - 1]) {
                    continue;
                }
                int c = b + 1;
                int d = len - 1;
                while (c < d) {
                    int sum = nums[a] + nums[b] + nums[c] + nums[d];
                    if (sum > target) {
                        d--;
                    } else if (sum < target) {
                        c++;
                    } else {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[a]);
                        list.add(nums[b]);
                        list.add(nums[c]);
                        list.add(nums[d]);
                        result.add(list);
                        while (c < d && nums[c] == nums[c + 1]) {
                            c++;
                        }
                        while (c < d && nums[d] == nums[d - 1]) {
                            d--;
                        }
                        c++;
                        d--;
                    }
                }
            }
        }
        return result;
    }
}
