import java.util.LinkedList;
import java.util.List;

public class lc_491 {
    List<List<Integer>> result = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();
    int[] nums;

    public List<List<Integer>> findSubsequences(int[] nums) {
        this.nums = nums;
        dfs(0);
        return result;
    }

    private void dfs(int start) {
        if (path.size() >= 2) {
            result.add(new LinkedList<>(path));
        }
        boolean[] used = new boolean[201];
        for (int i = start; i < nums.length; i++) {
            //递增
            if (!path.isEmpty() && path.getLast() > nums[i]) {
                continue;
            }
            //同一层去重
            if (used[nums[i] + 100]) {
                continue;
            }
            path.add(nums[i]);
            used[nums[i] + 100] = true;
            dfs(i + 1);
            path.removeLast();
        }
    }
}
