public class lc_88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //因为Nums1的末尾全部是0，所以从右往左遍历，不会覆盖原本的元素
        int idx1=m-1;
        int idx2=n-1;
        int idx=nums1.length-1;
        while(idx>=0){
            //若第二个数组还没有遍历完，此时需要比较
            if(idx2<0){
                nums1[idx--]=nums1[idx1--];
            }else if(idx1<0){
                nums1[idx--]=nums2[idx2--];
            }else if(nums1[idx1]<nums2[idx2]){
                nums1[idx--]=nums2[idx2--];
            }else{
                nums1[idx--]=nums1[idx1--];
            }
        }
    }
}
