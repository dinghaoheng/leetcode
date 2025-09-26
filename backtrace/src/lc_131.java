import java.util.LinkedList;
import java.util.List;

public class lc_131 {
    LinkedList<List<String>> result=new LinkedList<>();
    LinkedList<String> path=new LinkedList<>();
    String input;
    public List<List<String>> partition(String s) {
        this.input=s;
        dfs(0);
        return result;
    }
    private void dfs(int index){
        if (index>=input.length()){
            result.add(new LinkedList<>(path));
            return;
        }
        for (int i=index;i<input.length();i++){
            if (check(index,i)){
                path.add(input.substring(index,i+1));
            }else {
                continue;
            }
            dfs(i+1);
            path.removeLast();
        }
    }
    private boolean check(int start,int end){
        while (start<=end){
            if (input.charAt(start)!=input.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    //动态规划+回溯
    //注意填表顺序，由于dp[i][j]=dp[i+1][j-1],所以填表顺序为从下到上，从左到右，且只填写右上部分
    //----------------------------------------------------------------------------

    boolean[][] dp;
    public List<List<String>> partition2(String s) {
        this.input=s;
        dp=new boolean[s.length()][s.length()];
        filDpArr(s.toCharArray());
        dfs2(0);
        return result;
    }
    private void dfs2(int index){
        if (index>=input.length()){
            result.add(new LinkedList<>(path));
            return;
        }
        for (int i=index;i<input.length();i++){
            if (dp[index][i]){
                path.add(input.substring(index,i+1));
            }else {
                continue;
            }
            dfs(i+1);
            path.removeLast();
        }
    }
    private void filDpArr(char[] str){
        for (int i=str.length-1;i>=0;i--){
            for (int j=i;j<str.length;j++){
                if (str[i]==str[j]){
                    if (j-i<=1){
                        dp[i][j]=true;
                    }else {
                        dp[i][j]=dp[i+1][j-1];
                    }
                }
            }
        }
    }
}
