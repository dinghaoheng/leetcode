import java.util.LinkedList;
import java.util.List;

public class lc_797 {
    public static void main(String[] args) {
        int[][] arr = new int[4][4];
        arr[0] = new int[]{1, 2};
        arr[1] = new int[]{3};
        arr[2] = new int[]{3};
        arr[3] = new int[]{};
        System.out.println(1);
        System.out.println(1);
        System.out.println(1);
    }

    List<List<Integer>> result = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();
    int[][] graph;
    int n;

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        this.graph = graph;
        this.n = graph.length - 1;
        path.add(0);
        dfs(0);
        return result;
    }

    private void dfs(int idx) {
        if (idx == n) {
            result.add(new LinkedList<>(path));
            return;
        }
        for (int node : graph[idx]) {
            path.add(node);
            dfs(node);
            path.removeLast();
        }
    }
}
