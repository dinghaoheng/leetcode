/**
 * @Author: DHH
 * @Description:
 * @Modified By:
 * @Date: 2025/9/1020:04
 * @Version:
 */
public class lc_383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] arr = new int[26];
        for (int i = 0; i < ransomNote.length(); i++) {
            int idx=ransomNote.charAt(i)-'a';
            arr[idx]++;
        }
        for (int i = 0; i < magazine.length(); i++) {
            int idx=magazine.charAt(i)-'a';
            arr[idx]--;
        }
        for (int item : arr) {
            if (item>0){
                return false;
            }
        }
        return true;
    }
}
