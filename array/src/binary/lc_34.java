package binary;

public class lc_34 {
    public static void main(String[] args) {
        new lc_34().searchRange2(new int[]{5,7,7,8,8,10},8);
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

    public int[] searchRange2(int[] nums, int target) {
        int l=0;
        int r=nums.length-1;
        while(l<=r){
            int mid=l+((r-l)>>1);
            //当取到目标值时，改动右指针，保证nums[l]<=target永远成立
            //这样得到的结果就是l是最左边的目标值
            if(nums[mid]<target){
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        if(l==nums.length||nums[l]!=target){
            return new int[]{-1,-1};
        }
        int end=l;
        while(end+1<nums.length&&nums[end+1]==target){
            end++;
        }
        return new int[]{l,end};
    }
}
