public class lc_37 {
    public static void main(String[] args) {
    }

    boolean[][] colUsed=new boolean[9][9];
    boolean[][] rowUsed=new boolean[9][9];
    boolean[][][] blockUsed=new boolean[3][3][9];
    public void solveSudoku(char[][] board) {
        //由于数独中已经填写了部分数字，因此需要初始化
        initialize(board);
        sloveSudokuHelper(board);
        return;
    }
    private void initialize(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '1'; // 注意这里用 '1' 而不是 '0'
                    rowUsed[i][num] = true;
                    colUsed[j][num] = true;
                    blockUsed[i / 3][j / 3][num] = true;
                }
            }
        }
    }
    private boolean sloveSudokuHelper(char[][] board){
        for (int i=0;i<9;i++){
            for (int j=0;j<9;j++){
                if (board[i][j]!='.'){
                    continue;
                }
                for (int k=1;k<=9;k++){
                    if (isValid(i,j,k)){
                        colUsed[j][k-1]=true;
                        rowUsed[i][k-1]=true;
                        blockUsed[i/3][j/3][k-1]=true;
                        board[i][j]=(char) (k+'0');
                        if (sloveSudokuHelper(board)){
                            return true;
                        }
                        colUsed[j][k-1]=false;
                        rowUsed[i][k-1]=false;
                        blockUsed[i/3][j/3][k-1]=false;
                        board[i][j]='.';
                    }
                }
                return false;
            }
        }
        return true;
    }
    private boolean isValid(int row,int col,int num){
        if (colUsed[col][num-1]){
            return false;
        }
        if (rowUsed[row][num-1]){
            return false;
        }
        int blockRow=row/3;
        int blockCol=col/3;
        if (blockUsed[blockRow][blockCol][num-1]){
            return false;
        }
        return true;
    }
}
