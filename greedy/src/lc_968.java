
public class lc_968 {
    int result=0;
    public int minCameraCover(TreeNode root) {
        int rootStatus = dfs(root);
        if (rootStatus==0){
            result++;
        }
        return result;
    }

    /**
     * 0，无覆盖
     * 1，有摄像头
     * 2，有覆盖，无摄像头
     */
    public int dfs(TreeNode root){
        if (root==null){
            return 2;
        }
        int leftStatus= dfs(root.left);
        int rightStatus= dfs(root.right);
        //左右都是有覆盖的情况，因为自底层向上遍历，所以该节点为无覆盖
        if (leftStatus==2&&rightStatus==2){
            return 0;
        }
        //左右存在一个无覆盖的情况，需要防止摄像头
        if (leftStatus==0||rightStatus==0){
            result++;
            return 1;
        }
        if (leftStatus==1||rightStatus==1){
            return 2;
        }
        return -1;
    }
}
