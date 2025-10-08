public class lc_34 {
    public static void main(String[] args) {
        new lc_34().searchRange(new int[]{5,7,7,8,8,10},8);
    }
    public int[] searchRange(int[] nums, int target) {
        int start=-1;
        int end=-1;
        int l=0;
        int r=nums.length-1;
        while (l<=r){
            int mid=l+((r-l)>>1);
            if (nums[mid]==target){
                start=mid;
                while (start>0&&nums[start-1]==target){
                    start--;
                }
                end=mid;
                while (end<nums.length-1&&nums[end+1]==target){
                    end++;
                }
                break;
            }else if (nums[mid]>target){
                r=mid-1;
            }else {
                l=mid+1;
            }
        }
        return new int[]{start,end};
    }
}
