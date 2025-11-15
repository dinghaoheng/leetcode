public class lc_45 {
    public static void main(String[] args) {
        new lc_45().jump2(new int[]{2,3,1,1,4});
    }
    public int jump(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        int result = 0;
        int curMax = 0;
        int preMax=0;
        for (int i = 0; i < nums.length; i++) {
            //更新当前能到的最远距离
            curMax=Math.max(curMax,nums[i]+i);
            //若当前点已经是最远距离，则再往前需要再走一步
            //若当前点不是最远距离，那么跳到当前点都只需要一步即可
            if (i==preMax){
                result++;
                preMax=curMax;
                if (curMax>= nums.length-1){
                    break;
                }
            }
        }
        return result;
    }

    public int jump2(int[] nums) {
        int result=0;
        //当前可以到达的最远距离
        int curMax=0;
        //在已经走过的路程中，可以到达的最远距离
        int nextMax=0;
        //这里的极限只到n-2，因为最后一步就是目标，即便在最后一步判断出来，当前位置处于极限，也不需要再往前了
        for(int i=0;i<nums.length-1;i++){
            nextMax=Math.max(nextMax,i+nums[i]);
            if(i==curMax){
                result++;
                curMax=nextMax;
            }
        }
        return result;
    }
}
