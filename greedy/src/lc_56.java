import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class lc_56 {
    public static void main(String[] args) {
        int[] arr1=new int[]{2,3};
        int[] arr2=new int[]{4,5};
        int[] arr3=new int[]{6,7};
        int[] arr4=new int[]{8,9};
        int[] arr5=new int[]{1,10};
        new lc_56().merge(new int[][]{arr1,arr2,arr3,arr4,arr5});
    }
    public int[][] merge(int[][] intervals) {
        List<int[]> list=new LinkedList<>();
        Arrays.sort(intervals,(a,b)->{
            return Integer.compare(a[0],b[0]);
        });
        list.add(intervals[0]);
        for (int i=1;i<intervals.length;i++){
            //存在重叠区间
            int[] lastInterval=list.get(list.size()-1);
            if (intervals[i][0]<=lastInterval[1]){
                list.get(list.size()-1)[1]=Math.max(lastInterval[1],intervals[i][1]);
            }else {
                list.add(intervals[i]);
            }
        }
        return list.toArray(new int[list.size()][2]);
    }
}
