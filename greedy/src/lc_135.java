import java.util.Arrays;

public class lc_135 {
    public int candy(int[] ratings) {
        int[] candyArr = new int[ratings.length];
        candyArr[0] = 1;
        for (int i = 1; i < ratings.length; i++) {
            //先从左往右遍历，确定rating[i]>rating[i-1]的场景
            if (ratings[i] > ratings[i - 1]) {
                candyArr[i] = candyArr[i - 1] + 1;
            } else {
                candyArr[i] = 1;
            }
        }
        for (int i = ratings.length - 2; i >= 0; i--) {
            //从右往左遍历，如果遇到rating[i]>rating[i+1]的情况
            //candy[i]可以选择保持原样，或者candy[i+1]+1
            //为了保证candy[i]同时满足左右相邻
            //所以取二者的最大值
            if (ratings[i] > ratings[i + 1]) {
                candyArr[i] = Math.max(candyArr[i], candyArr[i + 1] + 1);
            }
        }
        return Arrays.stream(candyArr).sum();
    }

    /**
     * 一次遍历，且空间复杂度为1
     * 灵茶山艾府
     */
    public int candy2(int[] ratings) {
        int n=ratings.length;
        //预先每个人先分配一个糖果
        int result=n;
        for(int i=0;i<n;i++){
            //谷底需要共享
            int start= i>0&&ratings[i]>ratings[i-1] ? i-1 : i;
            //找到严格递增的上坡
            while(i+1<n&&ratings[i+1]>ratings[i]){
                i++;
            }
            int top=i;
            //找到严格递减的下坡
            while(i+1<n&&ratings[i+1]<ratings[i]){
                i++;
            }
            int bottom=i;
            //递增序列的长度，(不包含top)
            int inc=top-start;
            //递减序列的长度,(不包含top)
            int dec =i-top;
            //递增序列需要的糖果
            int incNum=(inc-1)*inc/2;
            //递减序列需要的糖果
            int decNum=(dec-1)*dec/2;
            //top需要的糖果
            int topNum=Math.max(dec,inc);
            result=result+incNum+decNum+topNum;
        }
        return result;
    }
}
