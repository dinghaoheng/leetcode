public class lc_189 {
    public void rotate(int[] nums, int k) {
        //这里需要处理，k超出n的情况
        k%=nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);

    }
    private void reverse(int[] nums,int a,int b){
        while(a<b){
            int temp=nums[b];
            nums[b]=nums[a];
            nums[a]=temp;
            a++;
            b--;
        }
    }
}
