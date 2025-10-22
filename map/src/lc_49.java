import java.util.*;

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

    public static void main(String[] args) {
        new lc_49().groupAnagrams2(new String[]{"eat","tea","tan","ate","nat","bat"});
    }
    public List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> map=new HashMap<>();
        for (String item : strs){
            String str=convert(item);
            if (map.containsKey(str)){
                map.get(str).add(item);
            }else {
                List<String> list=new LinkedList<>();
                list.add(item);
                map.put(str,list);
            }
        }
        return new ArrayList<>(map.values());
    }
    private String convert(String str){
        int[] map=new int[26];
        for (char item : str.toCharArray()){
            map[item-'a']++;
        }
        StringBuilder builder=new StringBuilder();
        for (int i=0;i<26;i++){
            builder.append(i+'a');
            builder.append(map[i]);
        }
        return builder.toString();
    }
}
