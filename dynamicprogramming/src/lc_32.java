public class lc_32 {
    public int longestValidParentheses(String s) {
        int n = s.length();
        int[] dp = new int[n];
        char[] arr = s.toCharArray();
        int result = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i] == '(') {
                continue;
            }
            //如果前一个是（,那么需要抛去前一个括号，加上前面的最大长度
            if (arr[i - 1] == '(') {
                dp[i] = i >= 2 ? dp[i - 2] + 2 : 2;
            } else if (i - dp[i - 1] >= 1 && arr[i - dp[i - 1] - 1] == '(') {
                //如果前一个是)，那么去掉前面的最大长度最后，一定有一个（和现在的)组成一个完整的括号
                dp[i] = dp[i - 1] + 2 + (i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2] : 0);
            }
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}
