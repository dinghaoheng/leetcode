import java.util.Arrays;

public class lc_455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int result=0;
        int i=0,j=0;
        while (i<g.length&&j<s.length){
            int numG=g[i];
            int numS=s[j];
            if (numS>=numG){
                i++;
                j++;
                result++;
            }else {
                j++;
            }
        }
        return result;
    }
}
