public class lc_74 {
    /**
     * 以右上角为起点开始搜索
     * 时间复杂度为m+n；空间复杂度为1
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length;
        int n=matrix[0].length;
        int r=0;
        int c=n-1;
        while(r>=0&&r<m&&c>=0&&c<n){
            int value=matrix[r][c];
            if(value==target){
                return true;
            }
            if(value>target){
                c--;
            }else{
                r++;
            }
        }
        return false;
    }
}
