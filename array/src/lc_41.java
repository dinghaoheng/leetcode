public class lc_41 {

    public static void main(String[] args) {
        new lc_41().firstMissingPositive(new int[]{0,1,2,3});
    }
    public int firstMissingPositive(int[] nums) {
        int n=nums.length;
        //只有[1,n]是需要的数字
        //当nums[i]==i+1时，则数字在正确的位置
        for(int i=0;i<n;i++){
            while(nums[i]>=1&&nums[i]<=n&&nums[i]!=nums[nums[i]-1]){
                //正确的位置
                int j=nums[i]-1;
                swap(nums,i,j);
            }
        }
        for(int i=0;i<n;i++){
            if(nums[i]!=i+1){
                return i+1;
            }
        }
        return n+1;
    }
    private void swap(int[] nums,int a,int b){
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }
}
