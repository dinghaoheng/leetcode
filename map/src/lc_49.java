import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: DHH
 * @Description:
 * @Modified By:
 * @Date: 2025/9/1020:18
 * @Version:
 */
public class lc_49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map=new HashMap<>();
        for (String str : strs) {
            StringBuilder builder=new StringBuilder();
            int[] arr=new int[26];
            for (int i = 0; i < str.length(); i++) {
                int idx=str.charAt(i)-'a';
                arr[idx]++;
            }
            for (int item : arr) {
                builder.append(item + 'a');
                builder.append(item);
            }
            List<String> list=map.getOrDefault(builder.toString(),new ArrayList<>());
            list.add(str);
        }
        return new ArrayList<>(map.values());
    }
}
