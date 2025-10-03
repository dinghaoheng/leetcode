import java.util.LinkedList;
import java.util.List;

public class lc_763 {
    public static void main(String[] args) {
    }

    public List<Integer> partitionLabels(String s) {
        int[] map = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char item = s.charAt(i);
            map[item - 'a'] = i;
        }
        int left = 0;
        int right = 0;
        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            //不断更新当前片段的终点
            right = Math.max(right, map[index]);
            //遇到终点，进行记录
            if (i == right) {
                result.add(right - left + 1);
                left = i + 1;
            }
        }
        return result;
    }

}
