package binary;

public class lc_162 {
    public int findPeakElement(int[] nums) {
        int l=0;
        int r=nums.length-2;
        //m<m+1,则峰顶在m右边，m是红色，更新l=m+1，红色=l-1；
        //m>m+1，则峰顶是m或者在m左边，m是蓝色，更新r=m-1,蓝色是r+1;
        //保持循环不变量，
        while(l<=r){
            int mid=l+((r-l)>>1);
            if(nums[mid]>nums[mid+1]){
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return r+1;
    }
}
