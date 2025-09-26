import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class lc_39 {
    LinkedList<List<Integer>> result=new LinkedList<>();
    LinkedList<Integer> path=new LinkedList<>();
    int[] arr;
    int target;
    int sum;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.arr=candidates;
        //先排序，方便sum过大时进行剪枝
        Arrays.sort(this.arr);
        this.target=target;
        dfs(0);
        return result;
    }
    private void dfs(int index){
        if (sum>=target){
            if (sum==target){
                result.add(new LinkedList<>(path));
            }
            return;
        }
        for (int i=index;i<arr.length;i++){
            if (sum+arr[i]>target){
                break;
            }
            path.add(arr[i]);
            sum+=arr[i];
            dfs(i);
            sum-=arr[i];
            path.removeLast();
        }
    }
}
