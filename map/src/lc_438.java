import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: DHH
 * @Description:
 * @Modified By:
 * @Date: 2025/9/1022:31
 * @Version:
 */
public class lc_438 {

    /**
     * 时间复杂度为o(m+n)
     */
    public List<Integer> findAnagrams2(String s, String p) {
        List<Integer> result=new LinkedList<>();
        if(s.length()<p.length()){
            return result;
        }
        int[] map=new int[26];
        for(char item : p.toCharArray()){
            map[item-'a']++;
        }
        //窗口左边
        int l=0;
        for(int r=0;r<s.length();r++){
            //字母加入窗口
            map[s.charAt(r)-'a']--;
            //因为窗口内的字母都是我们需要的
            //如果map[i]小于零，说明这个字母是多余的，需要通过滑动窗口来排除掉这个字母
            while(map[s.charAt(r)-'a']<0){
                //移除左边的元素
                map[s.charAt(l)-'a']++;
                l++;
            }
            //此时窗口已经满足要求，若长度也满足要求，就可以加入答案
            if(r-l+1==p.length()){
                result.add(l);
            }
        }
        return result;
    }


    int[] arrS = new int[26];
    int[] arrP = new int[26];

    /**
     * 时间复杂度为 o(m+(m-n)*26)
     */
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
        //此处需要判断
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
