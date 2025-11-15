import java.util.Deque;
import java.util.LinkedList;

public class lc_994 {
    public static void main(String[] args) {
        new lc_994().orangesRotting(new int[][]{{2,1,1},{1,1,0},{0,1,1}});
    }
    public int orangesRotting(int[][] grid) {
        Deque<int[]> queue = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        int fresh = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                } else if (grid[i][j] == 2) {
                    queue.addFirst(new int[] { i, j });
                }
            }
        }
        int ans = 0;
        int[][] direct = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        while (fresh > 0 && !queue.isEmpty()) {
            ans++;
            int size=queue.size();
            for (int i = 0; i < size; i++) {
                int[] node = queue.removeLast();
                for (int[] item : direct) {
                    int x = node[0] + item[0];
                    int y = node[1] + item[1];
                    if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] != 1) {
                        continue;
                    }
                    fresh--;
                    grid[x][y] = 2;
                    queue.addFirst(new int[] { x, y });
                }
            }
        }
        return fresh > 0 ? -1 : ans;
    }
}
