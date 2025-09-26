import java.util.LinkedList;
import java.util.List;

public class lc_216 {

    public static void main(String[] args) {
        new lc_216().combinationSum3(3,7);
    }

    int k;
    int n;
    LinkedList<List<Integer>> result = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();
    int sum;

    public List<List<Integer>> combinationSum3(int k, int n) {
        this.k=k;
        this.n=n;
        dfs(1);
        return result;
    }

    private void dfs(int start) {
        if (path.size() == k) {
            if (sum==n){
                result.add(new LinkedList<>(path));
            }
            return;
        }
        for (int i=start;i<=9-(k-path.size())+1;i++){
            path.add(i);
            sum+=i;
            dfs(i+1);
            path.removeLast();
            sum-=i;
        }
    }
}
