public class lc_45 {
    public static void main(String[] args) {
        new lc_45().jump(new int[]{2,3,1,1,4});
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
}
