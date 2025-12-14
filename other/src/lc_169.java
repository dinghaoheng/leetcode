public class lc_169 {
    public static void main(String[] args) {
        new lc_169().majorityElement(new int[]{6,5,5});
    }
    public int majorityElement(int[] nums) {
        //需要找出众数，且众数的数量>n/2，也就是比其他数加起来还多
        int num=0;
        int count=0;
        for(int item : nums){
            //如果数量被减为0，那么这个数的数量肯定不足n/2，就不是答案
            if(count==0){
                num=item;
                count=1;
            }else{
                count+=item==num ? 1:-1;
            }
        }
        return num;
    }
}
