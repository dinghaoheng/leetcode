import java.util.HashSet;
import java.util.Set;

/**
 * @Author: DHH
 * @Description:
 * @Modified By:
 * @Date: 2025/9/1022:35
 * @Version:
 */
public class lc_349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int i : nums1) {
            set1.add(i);
        }
        for (int i : nums2) {
            if (set1.contains(i)) {
                set2.add(i);
            }
        }
        int[] res=new int[set2.size()];
        int idx=0;
        for (Integer i : set2) {
            res[idx++]=i;
        }
        return res;
    }
}
