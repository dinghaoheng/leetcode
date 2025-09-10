import java.util.HashSet;
import java.util.Set;

/**
 * @Author: DHH
 * @Description:
 * @Modified By:
 * @Date: 2025/9/1023:01
 * @Version:
 */
public class lc_202 {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (true) {
            if (n == 1) {
                return true;
            }
            if (!set.add(n)) {
                return false;
            }
            n = getNum(n);
        }
    }

    private int getNum(int n) {
        int res = 0;
        while (n != 0) {
            int num = n % 10;
            res += num * num;
            n /= 10;
        }
        return res;
    }
}
