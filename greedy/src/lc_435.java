import java.util.Arrays;

public class lc_435 {
    /**
     * 本体需要找到不重复区间的个数
     * 用总数-不重复区间的个数=需要移除的区间数
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length==0){
            return 0;
        }
        Arrays.sort(intervals,(a,b)->{
            return a[1]-b[1];
        });
        int count=1;
        for (int i=1;i<intervals.length;i++){
            //存在重叠，更新右边界为最小右边界
            if (intervals[i][0]<intervals[i-1][1]){
                intervals[i][1]=intervals[i-1][1];
            }else {
                count++;
            }
        }
        return intervals.length-count;
    }
}
