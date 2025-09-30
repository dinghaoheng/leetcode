public class lc_55 {
    /**
     * 这题的本质在于判断重点能不能被覆盖到
     */
    public boolean canJump(int[] nums) {
        int cover=0;
        for (int i=0;i< nums.length;i++){
            if (i>cover){
                break;
            }
            int num=i+nums[i];
            if (num>=nums.length-1){
                return true;
            }
            cover=Math.max(cover,num);
        }
        return false;
    }
}
