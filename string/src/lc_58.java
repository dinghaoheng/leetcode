public class lc_58 {
    public static void main(String[] args) {
        new lc_58().lengthOfLastWord("   fly me   to   the moon  ");
    }
    public int lengthOfLastWord(String s) {
        int n=s.length();
        int end=n-1;
        while(s.charAt(end)==' '){
            end--;
        }
        int start=end-1;
        while(start>=0&&s.charAt(start)!=' '){
            start--;
        }
        return end-start;
    }
}
