import java.util.HashMap;
import java.util.Map;

/**
 * @Author: DHH
 * @Description:
 * @Modified By:
 * @Date: 2025/9/1023:35
 * @Version:
 */
public class lc_454 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i1 : nums1) {
            for (int i2 : nums2) {
                int sum = i1 + i2;
                Integer count = map.getOrDefault(sum, 0);
                map.put(sum, count + 1);
            }
        }
        for (int i3 : nums3) {
            for (int i4 : nums4) {
                int sum = -i3 - i4;
                Integer count = map.get(sum);
                if (count != null) {
                    result += count;
                }
            }
        }
        return result;
    }
}
