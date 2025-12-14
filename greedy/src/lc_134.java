public class lc_134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        //如果本题可以完成一个来回，那么gas的和必定大于cost的和
        //定义每一个点的油量为gas[i]-cost[i]
        //如果油量在某一步小于0，那么就不能往后走了，所以要找出油量最低的那个点作为起点
        int sum=0;
        int minSum=Integer.MAX_VALUE;
        int result=0;
        for(int i=0;i<gas.length;i++){
            sum+=gas[i]-cost[i];
            if(sum<minSum){
                minSum=sum;
                //消耗完cost之后，已经在下一个位置了，所以result=i+1
                result=i+1;
            }
        }
        //此时表示不可能走完一圈
        if(sum<0){
            return -1;
        }
        //环路处理，最后一个节点连着起点
        return result==gas.length ? 0:result;
    }
}
