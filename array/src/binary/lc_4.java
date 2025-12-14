package binary;

public class lc_4 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 3};
        int[] nums2 = new int[]{2};

        new lc_4().findMedianSortedArrays3(nums1, nums2);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int m = nums1.length;
        int n = nums2.length;
        int[] a = new int[m + 2];
        int[] b = new int[n + 2];
        a[0] = Integer.MIN_VALUE;
        a[m + 1] = Integer.MAX_VALUE;
        b[0] = Integer.MIN_VALUE;
        b[n + 1] = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            a[i + 1] = nums1[i];
        }
        for (int i = 0; i < n; i++) {
            b[i + 1] = nums2[i];
        }
        //nums1有i个数在第一组
        int i = 0;
        //nums2有j个数在第一组
        int j = (m + n + 1) / 2;
        while (a[i + 1] <= b[j]) {
            i++;
            j--;
        }
        //当循环退出时，满足a[i+1]>b[j]以及a[i]<b[j+1]
        int max1 = Math.max(a[i], b[j]);
        int min2 = Math.min(a[i + 1], b[j + 1]);
        return (m + n) % 2 == 0 ? (max1 + min2) / 2.0 : max1;
    }


    /**
     * 在前一种解法的基础上，引入二分，查找一个数，满足下列条件
     * 当前a[i]<b[j+1]，当i++后，满足a[i+1]>b[j]
     */
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays2(nums2, nums1);
        }
        int m = nums1.length;
        int n = nums2.length;
        int[] a = new int[m + 2];
        int[] b = new int[n + 2];
        a[0] = Integer.MIN_VALUE;
        a[m + 1] = Integer.MAX_VALUE;
        b[0] = Integer.MIN_VALUE;
        b[n + 1] = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            a[i + 1] = nums1[i];
        }
        for (int i = 0; i < n; i++) {
            b[i + 1] = nums2[i];
        }
        int l = 1;
        int r = m;
        while (l <= r) {
            int i = l + ((r - l) >> 1);
            int j = (m + n + 1) / 2 - i;
            if (a[i] <= b[j + 1]) {
                l = i + 1;
            } else {
                r = i - 1;
            }
        }
        //遍历结束之后，l的位置在i+1，我们需要找的是i，而不是i+1
        int i = r;
        int j = (m + n + 1) / 2 - i;
        int max1 = Math.max(a[i], b[j]);
        int min2 = Math.min(a[i + 1], b[j + 1]);
        return (m + n) % 2 > 0 ? max1 : (max1 + min2) / 2.0;
    }


    /**
     * 最优解，时间复杂度为o(logmin(m,n))
     * 将i改为i+1，j改为j=1
     * 在结尾再判断越界的情况，解决了前一种解法中需要覆盖数组的m和n的时间复杂度
     */
    public double findMedianSortedArrays3(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m > n) {
            return findMedianSortedArrays3(nums2, nums1);
        }
        //第一组有i个数在nums中，有j个数在nums2中
        int l = 0;
        int r = m - 1;
        while (l <= r) {
            //由于我们先计算i，求差得出j，因此需要保证m<=n，否则会数据越界
            int i = l + ((r - l) >> 1);
            //j+1=(m+n+1)/2-(i+1);
            int j = (m + n + 1) / 2 - i - 2;
            //第一个组的最大值小于第二组的最小值
            //Math.max(ai,aj)<=Math.min(ai+1,bj+1);
            if (nums1[i] <= nums2[j + 1]) {
                l = i + 1;
            } else {
                r = i - 1;
            }
        }
        //结束之后i处于ai+1的位置
        int i = r;
        int j = (m + n + 1) / 2 - i - 2;
        int ai = i == -1 ? Integer.MIN_VALUE : nums1[i];
        int bj = j == -1 ? Integer.MIN_VALUE : nums2[j];
        int ai1 = i + 1 == m ? Integer.MAX_VALUE : nums1[i + 1];
        int bi1 = j + 1 == n ? Integer.MAX_VALUE : nums2[j + 1];
        int max1 = Math.max(ai, bj);
        int max2 = Math.min(ai1, bi1);
        if ((m + n) % 2 != 0) {
            return max1;
        } else {
            return (max1 + max2) / 2.0;
        }
    }

}
