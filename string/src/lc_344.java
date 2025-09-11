public class lc_344 {
    public void reverseString(char[] s) {
        int l = 0;
        int r = s.length - 1;
        while (l <= r) {
            swap(s, l, r);
            l++;
            r--;
        }
    }

    private void swap(char[] chars, int a, int b) {
        char temp = chars[a];
        chars[a] = chars[b];
        chars[b] = temp;
    }
}
