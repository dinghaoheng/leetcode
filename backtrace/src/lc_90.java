import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class lc_90 {
    List<List<Integer>> result=new LinkedList<>();
    LinkedList<Integer> path=new LinkedList<>();
    int[]nums;
    boolean[] used;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        this.nums=nums;
        this.used=new boolean[nums.length];
        dfs(0);
        return result;
    }
    private void dfs(int start){
        result.add(new LinkedList<>(path));
        for (int i=start;i<nums.length;i++){
            if (i!=0&&nums[i]==nums[i-1]&&!used[i-1]){
                continue;
            }
            path.add(nums[i]);
            used[i]=true;
            dfs(i+1);
            path.removeLast();
            used[i]=false;
        }
    }
}
