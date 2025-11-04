public class lc_240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        //选择右上角为起点
        //若起点大于目标值，则当前列被抛弃，因为这个数是当前列中最大的
        //若起点小于目标值，则当前行被抛弃，因为这个数是当前行中最小的
        int r=0;
        int c=n-1;
        while(r<=m-1&&c>=0){
            int num=matrix[r][c];
            if(num==target){
                return true;
            }
            if(num>target){
                c--;
            }else{
                r++;
            }
        }
        return false;
    }
}
