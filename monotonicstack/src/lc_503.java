import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class lc_503 {
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int[] result = new int[len];
        Arrays.fill(result, -1);
        Deque<Integer> stack = new LinkedList<>();
        stack.addFirst(0);
        for (int i = 1; i < len * 2; i++) {
            int idx = i % len;
            if (nums[stack.peekFirst()] >= nums[idx]) {
                stack.addFirst(idx);
            } else {
                while (!stack.isEmpty() && nums[stack.peekFirst()] < nums[idx]) {
                    Integer num = stack.removeFirst();
                    result[num] = nums[idx];
                }
                stack.addFirst(idx);
            }
        }
        return result;
    }
}
