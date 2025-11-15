import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class lc_22 {
    List<String> result = new LinkedList<>();
    int n;
    List<Integer> path = new LinkedList<>();

    public List<String> generateParenthesis(int n) {
        this.n = n;
        dfs(0, 0);
        return result;
    }

    /**
     * 核心思想为，在递归的过程中，右括号的数量不能大于左括号的数量
     * i:已经填写了多少个括号
     * balance:还可以填写多少个右括号
     */
    private void dfs(int i, int balance) {
        //这里不能判断i==2*n,需要考虑填写了三个左括号，balance为0的情况
        if (path.size() == n) {
            char[] arr = new char[n * 2];
            Arrays.fill(arr, ')');
            for (Integer left : path) {
                arr[left] = '(';
            }
            result.add(new String(arr));
            return;
        }
        for (int right = 0; right <= balance; right++) {
            path.add(i + right);
            dfs(i + right + 1, balance - right + 1);
            path.remove(path.size() - 1);
        }
    }
}
