package binary;

public class lc_33 {
    public static void main(String[] args) {

    }
    /**
     * 做法1，两次二分，先二分一次找到最小值，再判断目标值在哪个区间中
     */
    public int search(int[] nums, int target) {
        int n=nums.length;
        int midIdx=findMid(nums);
        //若比最后一个数大，那么target在第一段
        if(target>nums[n-1]){
            return binarySearch(nums,0,midIdx-1,target);
        }
        return binarySearch(nums,midIdx,n-1,target);
    }
    private int binarySearch(int[] nums,int start,int end,int target){
        int l=start;
        int r=end;
        while(l<=r){
            int mid=l+((r-l)>>1);
            if(nums[mid]<target){
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        if(l==end+1||nums[l]!=target){
            return -1;
        }
        return l;
    }
    private int findMid(int[] nums){
        int n=nums.length;
        int l=0;
        int r=n-2;
        while(l<=r){
            int mid=l+((r-l)>>1);
            if(nums[mid]>nums[n-1]){
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        return l;
    }

    /**
     * 做法2，一次二分，分为三种情况，
     * mid在第一段，target在第二段
     * mid在第二段，target在第一段
     * 如果都在同一段，就可以按照常规二分去写
     */
    public int search2(int[] nums, int target) {
        int n=nums.length;
        int l=0;
        int r=n-2;
        while(l<=r){
            int mid=l+((r-l)>>1);
            int last=nums[n-1];
            //mid在第一段，target在第二段
            if(nums[mid]>last&&target<=last){
                l=mid+1;
            }else if(target>last&&nums[mid]<=last){
                r=mid-1;
            }else if(nums[mid]<target){
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        if(l==n||nums[l]!=target){
            return -1;
        }
        return l;
    }
}
