package binary;

public class lc_153 {
    public int findMin(int[] nums) {
        int n=nums.length;
        int l=0;
        int r=nums.length-2;
        while(l<=r){
            int mid =l+((r-l)>>1);
            //mid为红色，m在最小值左边
            if(nums[mid]>nums[n-1]){
                l=mid+1;
            }else{
                //mid位蓝色，m就是最值，或者在最小值右边
                r=mid-1;
            }
        }
        return nums[l];
    }
}
