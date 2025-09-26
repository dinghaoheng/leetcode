import java.util.LinkedList;
import java.util.List;

public class lc_77 {
    public static void main(String[] args) {
        new lc_77().combine(4,2);
    }

    List<List<Integer>> result=new LinkedList<>();
    List<Integer> path=new LinkedList<>();
    int n;
    int k;
    public List<List<Integer>> combine(int n, int k) {
        this.n=n;
        this.k=k;
        dfs(1);
        return result;
    }

    /**
     * 回溯，未剪枝做法
     * @param start
     */
    public void dfs(int start){
        if (path.size()==k){
            result.add(new LinkedList<>(path));
            return;
        }
        for (int i=start;i<=n;i++){
            path.add(i);
            dfs(i+1);
            path.remove(path.size()-1);
        }
    }


    /**
     * 剪枝，若剩下的数已经不满k个数，则无需再枚举
     */
    public void dfs2(int start){
        if (path.size()==k){
            result.add(new LinkedList<>(path));
            return;
        }
        for (int i=start;i<=n-(k-path.size())+1;i++){
            path.add(i);
            dfs2(i+1);
            path.remove(path.size()-1);
        }
    }
}
