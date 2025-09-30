public class lc_134 {
    /**
     * 若当前的[0,i]区间内的和小于0，代表从[0,i]之间的任何一个点都不能作为起点，将起点改为i+1
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int curSum=0;
        int totalSum=0;
        int start=0;
        for (int i=0;i<gas.length;i++){
            curSum+=gas[i]-cost[i];
            totalSum+=gas[i]-cost[i];
            if (curSum<0){
                start=i+1;
                curSum=0;
            }
        }
        if (totalSum<0){
            return -1;
        }
        return start;
    }
}
