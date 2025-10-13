public class lc_59 {
    public int[][] generateMatrix(int n) {
        int[][] matrix=new int[n][n];
        int row=0;
        int col=0;
        int num=1;
        for (int loop=0;loop<n/2;loop++){
            //这里row还没赋值，不符合条件，因此需要用matrix[loop][col]
            for (col=loop;col<n-loop-1;col++){
                matrix[loop][col]=num++;
            }
            for (row=loop;row<n-loop-1;row++){
                matrix[row][col]=num++;
            }
            for (;col>loop;col--){
                matrix[row][col]=num++;
            }
            for (;row>loop;row--){
                matrix[row][col]=num++;
            }
        }
        if (n%2!=0){
            matrix[n/2][n/2]=num;
        }
        return matrix;
    }

    public static void main(String[] args) {
        new lc_59().generateMatrix3(3);
    }
    public int[][] generateMatrix3(int n) {
        int[][] matrix = new int[n][n];
        int num = 1;
        int row = 0;
        int col = 0;
        for (int i = 0; i < n / 2; i++) {
            for (col = i; col < n - i - 1; col++) {
                matrix[i][col] = num++;
            }
            for (row = i; row < n - i - 1; row++) {
                matrix[row][col] = num++;
            }
            for (; col > i; col--) {
                matrix[row][col] = num++;
            }
            for (; row > i; row--) {
                matrix[row][col] = num++;
            }
        }
        if (n % 2 != 0) {
            matrix[n/2][n/2]=num;
        }
        return matrix;
    }
}
