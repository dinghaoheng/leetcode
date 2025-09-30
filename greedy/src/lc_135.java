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
}
