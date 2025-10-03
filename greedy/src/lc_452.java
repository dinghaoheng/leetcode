import java.util.Arrays;

public class lc_452 {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> {
            //防止二者相减出现溢出场景，需要使用Integer.compare
            return Integer.compare(a[0], b[0]);
        });
        int result = 1;
        for (int i = 1; i < points.length; i++) {
            //左边界大于前一个的右边界，则单独需要一个气球
            if (points[i][0] > points[i - 1][1]) {
                result++;
            } else {
                //若二者重合，则将当前的左边界改为和前一个的右边界相同
                points[i][1] = Math.min(points[i][1], points[i - 1][1]);
            }
        }
        return result;
    }
}
