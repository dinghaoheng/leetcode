public class lc_79 {
    boolean[][] visited;
    char[][] board;
    int m;
    int n;
    int[][] direct=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    String word;

    /**
     * 不做任何剪枝的做法
     * 时间复杂度为o(mn3^k)，mn为行和列，每次递归至多有三个分支
     * 空间复杂度问0(128+k)，128是字符集合的大小，k为栈的深度
     *
     */
    public boolean exist(char[][] board, String word) {
        this.word=word;
        this.board=board;
        this.m=board.length;
        this.n=board[0].length;
        this.visited=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(dfs(i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean dfs(int i,int j,int idx){
        if(word.charAt(idx)!=board[i][j]){
            return false;
        }
        if(idx==word.length()-1){
            return true;
        }
        visited[i][j]=true;
        for(int[] item :direct){
            int x=item[0]+i;
            int y=item[1]+j;
            if(x<0||x>=m||y<0||y>=n||visited[x][y]){
                continue;
            }
            if(dfs(x,y,idx+1)){
                return true;
            }
        }
        visited[i][j]=false;
        return false;
    }


    char[] wordArr;

    /**
     * 剪枝优化
     */
    public boolean exist2(char[][] board, String word) {
        this.wordArr=word.toCharArray();
        this.board=board;
        this.m=board.length;
        this.n=board[0].length;
        this.visited=new boolean[m][n];
        //优化1，如果某一个字母，在board中出现的次数不足，直接返回false
        int[] map=new int[128];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                map[board[i][j]]++;
            }
        }
        int[] wordMap=new int[128];
        for(char item : wordArr){
            wordMap[item]++;
            if(wordMap[item]>map[item]){
                return false;
            }
        }
        //优化2，如果末尾的字母更加罕见，则从末尾开始遍历
        if(map[wordArr[wordArr.length-1]]<map[wordArr[0]]){
            wordArr=new StringBuilder(word).reverse().toString().toCharArray();
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(dfs2(i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean dfs2(int i,int j,int idx){
        if(wordArr[idx]!=board[i][j]){
            return false;
        }
        if(idx==wordArr.length-1){
            return true;
        }
        visited[i][j]=true;
        for(int[] item :direct){
            int x=item[0]+i;
            int y=item[1]+j;
            if(x<0||x>=m||y<0||y>=n||visited[x][y]){
                continue;
            }
            if(dfs(x,y,idx+1)){
                return true;
            }
        }
        visited[i][j]=false;
        return false;
    }
}
