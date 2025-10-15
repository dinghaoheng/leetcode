import java.util.LinkedList;
import java.util.List;

public class lc_54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result=new LinkedList<>();
        int row=matrix.length;
        int col=matrix[0].length;
        int top=0;
        int left=0;
        int right=col-1;
        int bottom=row-1;
        while (left<=right&&top<=bottom){
            //为了防止最后一圈出现一条线的情况
            //遍历top和right的时候，需要覆盖到最右边和最下方
            for (int i=left;i<=right;i++){
                result.add(matrix[top][i]);
            }
            for (int i=top+1;i<=bottom;i++){
                result.add(matrix[i][right]);
            }
            if (top!=bottom&&left!=right){
                for (int i=right-1;i>left;i--){
                    result.add(matrix[bottom][i]);
                }
                for (int i=bottom;i>top;i--){
                    result.add(matrix[i][left]);
                }
            }
            top++;
            left++;
            right--;
            bottom--;
        }
        return result;
    }
}
