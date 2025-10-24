public class lc_200 {
    private int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private char[][] grid;

    public int numIslands(char[][] grid) {
        this.grid = grid;
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    visited[i][j] = true;
                    result++;
                    dfs(visited, i, j);
                }
            }
        }
        return result;
    }

    private void dfs(boolean[][] visited, int i, int j) {
        for (int k = 0; k < 4; k++) {
            int x = i + dir[k][0];
            int y = j + dir[k][1];
            if (x < 0 || y < 0 || x >= visited.length || y >= visited[0].length) {
                continue;
            }
            if (!visited[x][y] && grid[x][y] == '1') {
                visited[x][y] = true;
                dfs(visited, x, y);
            }
        }
    }
}
