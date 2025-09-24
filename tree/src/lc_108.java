import java.util.ArrayDeque;
import java.util.Deque;

public class lc_108 {
    int[] nums;

    public TreeNode sortedArrayToBST(int[] nums) {
        this.nums=nums;
        return build(0,nums.length-1);
    }

    private TreeNode build(int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + ((end - start) >>1);
        TreeNode root = new TreeNode(nums[mid]);
        root.left=build(start,mid-1);
        root.right=build(mid+1,end);
        return root;
    }


    /**
     * 栈模拟递归
     */
    public TreeNode sortedArrayToBST2(int[] nums) {
        TreeNode root=new TreeNode();
        Deque<Object> stack=new ArrayDeque<>();
        stack.addFirst(root);
        stack.addFirst(0);
        stack.addFirst(nums.length-1);
        while (!stack.isEmpty()){
            Integer right=(Integer) stack.removeFirst();
            Integer left=(Integer) stack.removeFirst();
            TreeNode node=(TreeNode) stack.removeFirst();
            int mid=left+((right-left)>>1);
            node.val=nums[mid];
            if (left<mid){
                TreeNode leftNode=new TreeNode();
                node.left=leftNode;
                stack.addFirst(leftNode);
                stack.addFirst(left);
                stack.addFirst(mid-1);
            }
            if (right>mid){
                TreeNode rightNode=new TreeNode();
                node.right=rightNode;
                stack.addFirst(rightNode);
                stack.addFirst(mid+1);
                stack.addFirst(right);
            }
        }
        return root;
    }
}
