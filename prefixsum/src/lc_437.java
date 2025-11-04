import java.util.HashMap;
import java.util.Map;

public class lc_437 {
    Map<Long, Integer> map = new HashMap<>();
    int result = 0;
    int targetSum;

    public int pathSum(TreeNode root, int targetSum) {
        this.targetSum = targetSum;
        map.put(0L, 1);
        dfs(root, 0);
        return result;
    }

    private void dfs(TreeNode root, long sum) {
        if (root == null) {
            return;
        }
        //记录前缀和
        sum += root.val;
        long target = sum - targetSum;
        result += map.getOrDefault(target, 0);
        Integer count = map.getOrDefault(sum, 0);
        map.put(sum, count + 1);
        dfs(root.left, sum);
        dfs(root.right, sum);
        //由于求和的方向只能由根节点向下，所以当前节点计算完左右子树之后，需要撤回该节点的值
        map.put(sum, count);
    }
}
