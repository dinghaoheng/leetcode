public class lc_35 {
    public int searchInsert(int[] nums, int target) {
        int l=0;
        int r=nums.length-1;
        while (l<=r){
            int mid=l+((r-l)>>1);
            if (nums[mid]==target){
                return mid;
            }
            if (nums[mid]>target){
                r=mid-1;
            }else {
                l=mid+1;
            }
        }
        //1.若插入位置为所以元素之前，则l=0；r=-1,返回r+1
        //2.若插入位置为元素之中，在nums[mid]<target的情况和nums[mid]>target的情况，都是返回r+1
        //3.若插入位置在所有元素之后，则，l=r+1，r=r，返回r+1
        return r+1;
    }
}
