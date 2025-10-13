import java.util.HashMap;
import java.util.Map;

public class lc_76 {
    /**
     * 用map保存结果，当targetNum归零时，认为是满足条件
     */
    public String minWindow(String s, String t) {
        Map<Character, Integer> targetMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            int count = targetMap.getOrDefault(t.charAt(i), 0);
            targetMap.put(t.charAt(i), count + 1);
        }
        int targetNum = targetMap.size();
        int l = 0;
        int lResult = 0;
        int length = Integer.MAX_VALUE;
        Map<Character, Integer> windows = new HashMap<>();
        for (int r = 0; r < s.length(); r++) {
            char sChar = s.charAt(r);
            if (targetMap.containsKey(sChar)) {
                int count = windows.getOrDefault(sChar, 0) + 1;
                windows.put(sChar, count);
                if (count == targetMap.get(sChar)) {
                    targetNum--;
                }
            }
            //滑动、缩小窗口
            while (targetNum == 0) {
                int curLen = r - l + 1;
                if (curLen < length) {
                    lResult = l;
                    length = curLen;
                }
                char lChar = s.charAt(l);
                if (targetMap.containsKey(lChar)) {
                    Integer count = windows.get(lChar);
                    windows.put(lChar, count - 1);
                    if (count.equals(targetMap.get(lChar))) {
                        targetNum++;
                    }
                }
                l++;
            }
        }
        return length == Integer.MAX_VALUE ? "" : s.substring(lResult, lResult + length);
    }

    public static void main(String[] args) {
        new lc_76().minWindow2("ADOBECODEBANC","ABC");
    }

    public String minWindow2(String s, String t) {
        Map<Character, Integer> targetMap = new HashMap<>();
        for (char item : t.toCharArray()) {
            Integer count = targetMap.getOrDefault(item, 0);
            targetMap.put(item, count + 1);
        }
        int num = targetMap.size();
        Map<Character, Integer> window = new HashMap<>();
        int l = 0;
        int lResult = 0;
        int result = Integer.MAX_VALUE;
        for (int r = 0; r < s.length(); r++) {
            char charS=s.charAt(r);
            //在字符串为需要字符的时候，再进行存入操作，可以节约时间
            if (targetMap.containsKey(charS)){
                Integer sCount = window.getOrDefault(charS, 0);
                window.put(charS, sCount + 1);
                Integer target = targetMap.get(charS);
                if (target == sCount + 1) {
                    num--;
                }
            }
            while (num == 0) {
                char charL=s.charAt(l);
                //记录答案
                int length = r - l + 1;
                if (length < result) {
                    result = length;
                    lResult = l;
                }
                //弹出元素
                if (targetMap.containsKey(charL)) {
                    Integer lCount = window.get(charL);
                    Integer targetCount = targetMap.get(charL);
                    if (targetCount.equals(lCount)) {
                        num++;
                    }
                    window.put(charL, lCount - 1);
                }
                l++;
            }
        }
        if (result == Integer.MAX_VALUE) {
            return "";
        }
        return s.substring(lResult, lResult + result);
    }

}
