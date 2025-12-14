public class lc_136 {
    public int singleNumber(int[] nums) {
        int result=0;
        for(int item : nums){
            //按位异或，相同的数字会被消除
            result^=item;
        }
        return result;
    }
}
