package completeknapsack;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class lc_139 {
    int[] memory;
    Set<String> set;
    String str;

    /**
     * 方法1，记忆化搜索
     * 时间复杂度，每个单词有两个状态，选或者不选，2^n
     * 空间复杂的，递归栈空间，n
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        set = new HashSet<>(wordDict);
        memory = new int[s.length()];
        str = s;
        return dfs(0);
    }

    private boolean dfs(int idx) {
        if (idx == str.length()) {
            return true;
        }
        if (memory[idx] != 0) {
            return memory[idx] == 1;
        }
        for (int i = idx; i <= str.length(); i++) {
            if (set.contains(str.substring(idx, i))) {
                if (dfs(i)) {
                    memory[idx] = 1;
                    return true;
                }
            }
        }
        memory[idx] = -1;
        return false;
    }


    /**
     * 时间复杂度n^2
     * 空间复杂度n
     */
    public boolean wordBreak2(String s, List<String> wordDict) {
        //dp[j]表示，s.subString(0,j)可以由字典组成
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int j = 1; j <= s.length(); j++) {
            for (int i = 0; i < wordDict.size(); i++) {
                String word = wordDict.get(i);
                int len = word.length();
                //若扣除当前单词，剩余的字符串为true，则dp[j]=true
                if (j >= len && dp[j - len] && s.substring(j - len, j).equals(word)) {
                    dp[j]=true;
                }
            }
        }
        return dp[s.length()];
    }
}
