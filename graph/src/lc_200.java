import java.util.Deque;
import java.util.LinkedList;

public class lc_200 {
    private int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private char[][] grid;

    public int numIslandsDFS(char[][] grid) {
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

    int rNum;
    int cNum;
    public int numIslandsBFS(char[][] grid) {
        this.grid=grid;
        this.rNum=grid.length;
        this.cNum=grid[0].length;
        int res=0;
        for (int r=0;r<rNum;r++){
            for (int c=0;c<cNum;c++){
                if (grid[r][c]=='1'){
                    res++;
                    bfs(r,c);
                }
            }
        }
        return res;
    }
    private void bfs(int r,int c){
        Deque<int[]> queue=new LinkedList<>();
        queue.addFirst(new int[]{r,c});
        grid[r][c]='0';
        while (!queue.isEmpty()){
            int[] node=queue.removeLast();
            for (int i=0;i<4;i++){
                int[] dirArr=dir[i];
                int x=node[0]+dirArr[0];
                int y=node[1]+dirArr[1];
                if (x<0||x>=rNum||y<0||y>=cNum||grid[x][y]=='0'){
                    continue;
                }
                grid[x][y]='0';
                queue.addFirst(new int[]{x,y});
            }
        }
    }
}
