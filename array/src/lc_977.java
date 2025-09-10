public class lc_977 {


    //模拟
    public int[] sortedSquares(int[] nums) {
        int[] result=new int[nums.length];
        int l=0;
        int r=nums.length-1;
        int idx=nums.length-1;
        for (int i=0;i<nums.length;i++){
            int sqrL= nums[l]*nums[l];
            int sqlR= nums[r]*nums[r];
            if (sqrL<=sqlR){
                result[idx]=sqlR;
                r--;
            }else {
                result[idx]=sqrL;
                l++;
            }
            idx--;
        }
        return result;
    }
}
