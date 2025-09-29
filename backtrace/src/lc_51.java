import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class lc_51 {
    public static void main(String[] args) {
        new lc_51().solveNQueens(4);
    }
    List<List<String>> result=new LinkedList<>();
    char[][] chessBoard;
    //用于记录列
    boolean[] colUsed;
    //用于记录45度对角线，45度对角线上面的数字有固定的row+col
    boolean[] diag45Used;
    //用于记录135度对角线，135度对角线上面的数字有固定的row-col
    boolean[] diag135Used;
    int n;
    public List<List<String>> solveNQueens(int n) {
        this.n=n;
        chessBoard=new char[n][n];
        for (char[] item : chessBoard){
            Arrays.fill(item,'.');
        }
        colUsed=new boolean[n];
        diag45Used=new boolean[2*n-1];
        diag135Used=new boolean[2*n-1];
        dfs(0);
        return result;
    }
    private void dfs(int row){
        if (row==n){
            result.add(convert());
            return;
        }
        for (int col=0;col<n;col++){
            if (check(row,col)){
                colUsed[col]=true;
                diag45Used[col+row]=true;
                diag135Used[row-col+n-1]=true;
                chessBoard[row][col]='Q';
                dfs(row+1);
                chessBoard[row][col]='.';
                colUsed[col]=false;
                diag45Used[col+row]=false;
                diag135Used[row-col+n-1]=false;
            }
        }
    }
    private boolean check(int row,int col){
        if (colUsed[col]){
            return false;
        }
        if (diag45Used[row+col]){
            return false;
        }
        if (diag135Used[row-col+n-1]){
            return false;
        }
        return true;
    }
    private List<String> convert(){
        List<String> list=new LinkedList<>();
        for (char[] item : chessBoard){
            list.add(new String(item));
        }
        return list;
    }
}
