package kmp;

public class lc_459 {

    /**
     * 暴力解，时间复杂度为n*n
     * i为初始子字符串的长度
     */
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        for (int i = 1; i <= len / 2; i++) {
            if (len % i != 0) {
                continue;
            }
            boolean check = true;
            for (int j = i; j < len; j++) {
                if (s.charAt(j) != s.charAt(j - i)) {
                    check = false;
                    break;
                }
            }
            if (check) {
                return true;
            }
        }
        return false;
    }

 //------------------------------------------------------------------------------

    /**
     * 使用KMP
     * 若最大长度前后缀不包含的字符串，长度可以整除s,则该字符串就是重复的子字符串
     */
    public boolean repeatedSubstringPatternKmp(String s) {
        int[] next = getNext(s);
        int len = s.length();
        int jLen = next[len - 1];
        return jLen > 0 && len % (len - jLen) == 0;
    }

    private int[] getNext(String s) {
        int[] result = new int[s.length()];
        int i = 1;
        int j = 0;
        result[0] = j;
        for (; i < s.length(); i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = result[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }
            result[i] = j;
        }
        return result;
    }

}
