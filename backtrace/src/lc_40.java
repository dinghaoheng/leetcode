import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class lc_40 {
    LinkedList<List<Integer>> result=new LinkedList<>();
    LinkedList<Integer> path=new LinkedList<>();
    int[] arr;
    int target;
    int sum;
    boolean[] used;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        this.arr=candidates;
        //先排序，方便sum过大时进行剪枝
        Arrays.sort(this.arr);
        this.target=target;
        used=new boolean[arr.length];
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
            if (i!=0&&arr[i]==arr[i-1]&&!used[i-1]){
                continue;
            }
            path.add(arr[i]);
            sum+=arr[i];
            used[i]=true;
            dfs(i+1);
            sum-=arr[i];
            used[i]=false;
            path.removeLast();
        }
    }
}
