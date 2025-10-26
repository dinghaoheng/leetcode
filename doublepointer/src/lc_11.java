public class lc_11 {
    public int maxArea(int[] height) {
        int l=0;
        int r=height.length-1;
        int res=0;
        while (l<r){
            int lHeight=height[l];
            int rHeight=height[r];
            //移动高度小的那个墙，因为容积又较矮的墙决定
            //如果移动较高的墙，容积一定会减小
            if (lHeight<=rHeight){
                res=Math.max(res,(r-l)*lHeight);
                l++;
            }else {
                res=Math.max(res,(r-l)*rHeight);
                r--;
            }
        }
        return res;
    }
}
