public class lc_31 {

    public void nextPermutation(int[] nums) {
        int n=nums.length;
        for(int i=n-1;i>0;i--){
            //从右往左找，找出第一个递减的数，这个数的右边一定存在一个数，比这个数要大
            //此时，i-1就是我们需要调整位置的数
            if(nums[i]>nums[i-1]){
                for(int j=n-1;j>=i;j--){
                    //找出第一个比这个数更大的数，进行交换
                    if(nums[j]>nums[i-1]){
                        swap(nums,j,i-1);
                        //交换完成之后，剩下的数从右往左看依然保持递增，此时需要反转
                        reverse(nums,i,n-1);
                        return;
                    }
                }
            }
        }
        //如果在前面没有返回，说明该序列就是单调递减的，反转即可
        reverse(nums,0,n-1);
    }
    private void swap(int[] nums,int a,int b){
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }
    private void reverse(int[] nums,int l,int r){
        while(l<r){
            swap(nums,l,r);
            l++;
            r--;
        }
    }
}
