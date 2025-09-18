public class lc_222a {
    public static void main(String[] args) {
        TreeNode node1=new TreeNode(1);
        TreeNode node2=new TreeNode(2);
        TreeNode node3=new TreeNode(3);
        TreeNode node4=new TreeNode(4);
        TreeNode node5=new TreeNode(5);
        TreeNode node6=new TreeNode(6);
        node1.left=node2;
        node1.right=node3;
        node2.left=node4;
        node2.right=node5;
        node3.left=node6;
        new lc_222a().countNodes(new TreeNode(1));
    }
    public int countNodes(TreeNode root) {
        if (root==null){
            return 0;
        }
        int level=0;
        TreeNode node=root;
        while (node.left!=null){
            //完全二叉树的叶子节点全部在左侧
            node=node.left;
            level++;
        }
        int min=1<<level;
        int max=(1<<(level+1))-1;
        int lastExist=0;
        //用二分法判断mid节点是否存在
        while (min<=max){
            int mid=min+((max-min)>>1);
            if (exist(level,mid,root)){
                lastExist=mid;
                min=mid+1;
            }else {
                max=mid-1;
            }
        }
        return lastExist;
    }

    private boolean exist(int level,int k,TreeNode root){
        //特殊判断，当层数为0，直接返回k是否为1
        if (level==0){
            return k==1;
        }
        //创建一个掩码，最高为是1，其余都是0，用于判断k的二进制各位是0还是1
        //这里层数从0开始计算，所以对于k的位运算会略过最高位
        int bit=1<<(level-1);
        TreeNode node= root;
        while (bit!=0&&node!=null){
            //与运算，都为1才是1，否则是0，用于检测当前为是不是1
            if ((bit&k)==0){
                node=node.left;
            }else {
                node=node.right;
            }
            //向右移动掩码，检测下一位
            bit>>=1;
        }
        return node!=null;
    }

    /**
     * 判断往左遍历和往右遍历的深度是否相同，若相同就是满二叉树
     * 满二叉树的节点数量为2^n-1，n为深度(1开始)
     */
    public int countNodes2(TreeNode root) {
        if (root==null){
            return 0;
        }
        int leftLen=0;
        int rightLen=0;
        TreeNode left=root.left;
        TreeNode right=root.right;
        while (left!=null){
            leftLen++;
            left=left.left;
        }
        while (right!=null){
            rightLen++;
            right=right.right;
        }
        if (leftLen==rightLen){
            return (1<<(leftLen+1))-1;
        }
        return countNodes(root.left)+countNodes(root.right)+1;
    }
}
