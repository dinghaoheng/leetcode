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
        int lResult=0;
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
            while (targetNum ==0){
                int curLen=r-l+1;
                if (curLen<length){
                    lResult=l;
                    length=curLen;
                }
                char lChar=s.charAt(l);
                if (targetMap.containsKey(lChar)){
                    Integer count=windows.get(lChar);
                    windows.put(lChar,count-1);
                    if (count.equals(targetMap.get(lChar))){
                        targetNum++;
                    }
                }
                l++;
            }
        }
        return length ==Integer.MAX_VALUE? "":s.substring(lResult,lResult+length);
    }
}
