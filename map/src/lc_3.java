import java.util.HashSet;
import java.util.Set;

public class lc_3 {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set=new HashSet<>();
        int l=0;
        int res=0;
        for(int r=0;r<s.length();r++){
            while(!set.add(s.charAt(r))){
                set.remove(s.charAt(l));
                l++;
            }
            res=Math.max(res,set.size());
        }
        return res;
    }
}
