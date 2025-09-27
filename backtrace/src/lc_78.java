import java.util.LinkedList;
import java.util.List;

public class lc_78 {
    List<List<Integer>> result= new LinkedList<>();
    LinkedList<Integer> path=new LinkedList<>();
    int[] nums;
    public List<List<Integer>> subsets(int[] nums) {
        this.nums=nums;
        dfs(0);
        return result;
    }
    private void dfs(int start){
        result.add(new LinkedList<>(path));
        for (int i=start;i<nums.length;i++){
            path.add(nums[i]);
            dfs(i+1);
            path.removeLast();
        }
    }
}
