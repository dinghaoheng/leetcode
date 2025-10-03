public class lc_738 {
    public static void main(String[] args) {
        new lc_738().monotoneIncreasingDigits(1234);
    }

    public int monotoneIncreasingDigits(int n) {
        char[] arr = Integer.toString(n).toCharArray();
        int start = arr.length;
        for (int i = arr.length - 2; i >= 0; i--) {
            int curNum = arr[i] - '0';
            int afterNum = arr[i + 1] - '0';
            if (curNum > afterNum) {
                arr[i] = (char) ((curNum - 1) + '0');
                start = i + 1;
            }
        }
        for (int i = start; i < arr.length; i++) {
            arr[i] = '9';
        }
        return Integer.parseInt(new String(arr));
    }

}
