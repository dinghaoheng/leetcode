public class lc_36 {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] colHas = new boolean[9][9];
        boolean[][] rowHas = new boolean[9][9];
        boolean[][][] subBoxHash = new boolean[3][3][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char item = board[i][j];
                if (item == '.') {
                    continue;
                }
                int num = item - '1';
                if (colHas[j][num] || rowHas[i][num] || subBoxHash[i / 3][j / 3][num]) {
                    return false;
                }
                colHas[j][num] = true;
                rowHas[i][num] = true;
                subBoxHash[i / 3][j / 3][num] = true;
            }
        }
        return true;
    }
}
