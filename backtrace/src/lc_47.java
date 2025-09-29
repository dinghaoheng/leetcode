import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class lc_47 {
    List<List<Integer>> result = new LinkedList();
    LinkedList<Integer> path = new LinkedList();
    int[] nums;
    boolean[] used;

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        this.nums = nums;
        this.used = new boolean[nums.length];
        dfs();
        return result;
    }

    private void dfs() {
        if (path.size() == nums.length) {
            result.add(new LinkedList(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            if (used[i]) {
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            dfs();
            path.removeLast();
            used[i] = false;
        }
    }
}
