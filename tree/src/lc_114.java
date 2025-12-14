public class lc_114 {
    /**
     * 找到每一个右节点的前驱节点，空间复杂度为o1
     */
    public void flatten(TreeNode root) {
        TreeNode head=root;
        while(head!=null){
            if(head.left!=null){
                TreeNode cur=head.left;
                TreeNode temp=cur;
                //找到左边数的最右边节点，这个节点就是右边树的前驱节点
                while(temp.right!=null){
                    temp=temp.right;
                }
                temp.right=head.right;
                head.left=null;
                head.right=cur;
            }
            head=head.right;
        }
    }
}
