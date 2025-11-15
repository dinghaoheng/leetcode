import java.util.Random;

public class lc_912 {
    private final Random ran=new Random();
    public int[] sortArray(int[] nums) {
        quick(nums,0,nums.length-1);
        return nums;
    }
    private void quick(int[] nums,int l,int r){
        if(l>=r){
            return;
        }
        int part=partition(nums,l,r);
        quick(nums,l,part-1);
        quick(nums,part+1,r);
    }
    private int partition(int[] nums,int l,int r){
        int idx=l+ran.nextInt(r-l+1);
        int pivot=nums[idx];
        swap(nums,l,idx);
        int i=l+1;
        int j=r;
        while(true){
            while(i<=j&&nums[i]<pivot){
                i++;
            }
            while(i<=j&&nums[j]>pivot){
                j--;
            }
            if(i>=j){
                break;
            }
            swap(nums,i,j);
            i++;
            j--;
        }
        swap(nums,l,j);
        return j;
    }
    private void swap(int[] nums,int a,int b){
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }
}
