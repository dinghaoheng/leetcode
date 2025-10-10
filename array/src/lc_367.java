public class lc_367 {
    public boolean isPerfectSquare(int num) {
        int l=1;
        int r=num;
        while (l<=r){
            int mid=l+((r-l)>>1);
            //使用long，防止溢出
            long sqr=(long) mid*mid;
            if (sqr==num){
                return true;
            }else if (sqr>num){
                r=mid-1;
            }else {
                l=mid+1;
            }
        }
        return false;
    }
}
