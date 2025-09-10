import java.util.ArrayList;
import java.util.List;

/**
 * @Author: DHH
 * @Description:
 * @Modified By:
 * @Date: 2025/9/1022:31
 * @Version:
 */
public class lc_438 {
    int[] arrS = new int[26];
    int[] arrP = new int[26];

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int lenS = s.length();
        int lenP = p.length();
        if (s.length() < p.length()) {
            return result;
        }
        for (int i = 0; i < lenP; i++) {
            arrS[convert(s.charAt(i))]++;
            arrP[convert(p.charAt(i))]++;
        }
        for (int i = lenP; i < lenS; i++) {
            if (check()) {
                result.add(i - lenP);
            }
            arrS[convert(s.charAt(i - lenP))]--;
            arrS[convert(s.charAt(i))]++;
        }
        if (check()) {
            result.add(lenS - lenP);
        }
        return result;
    }

    private boolean check() {
        for (int i = 0; i < 26; i++) {
            if (arrS[i] != arrP[i]) {
                return false;
            }
        }
        return true;
    }

    private int convert(char item) {
        return item - 'a';
    }
}
