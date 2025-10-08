public class lc_69 {
    public static void main(String[] args) {
        new lc_69().mySqrt(8);
    }
    public int mySqrt(int x) {
        int result=0;
        int l=1;
        int r=x;
        while (l<=r){
            int mid=l+((r-l)>>1);
            long sqr=(long) mid*mid;
            if (sqr==x){
                return mid;
            }else if (sqr<x){
                result=mid;
                l=mid+1;
            }else {
                r=mid-1;
            }
        }
        return result;
    }
}
