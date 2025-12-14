public class lc_80 {
    public static void main(String[] args) {
        new lc_80().removeDuplicates(new int[]{1,1,1,2,2,3});
    }
    public int removeDuplicates(int[] nums) {
        int l=0;
        for(int r=0;r<nums.length;r++){
            if(r<2||nums[r]!=nums[l-2]){
                nums[l++]=nums[r];
            }
        }
        return l;
    }
}
