/**
 * @Author: DHH
 * @Description:
 * @Modified By:
 * @Date: 2025/9/1020:01
 * @Version:
 */
public class lc_242 {
    /**
     * 用数组替代map
     **/
    public boolean isAnagram(String s, String t) {
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            arr[idx]++;
        }
        for (int i = 0; i < t.length(); i++) {
            int idx = t.charAt(i) - 'a';
            arr[idx]--;
        }
        for (int item : arr) {
            if (item != 0) {
                return false;
            }
        }
        return true;
    }
}
