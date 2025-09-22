import java.util.HashMap;
import java.util.Map;

public class lc_105 {
    int[] preorder;
    int[] inorder;
    Map<Integer,Integer> map=new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        this.preorder=preorder;
        this.inorder=inorder;
        return build(0,preorder.length-1,0,inorder.length-1);
    }
    private TreeNode build(int preStart,int preEnd,int inStart,int inEnd){
        if (preStart>preEnd||inStart>inEnd){
            return null;
        }
        int rootValue=preorder[preStart];
        int rootIndex=map.get(rootValue);
        int leftCount=rootIndex-inStart;
        TreeNode root=new TreeNode(rootValue);
        root.left=build(preStart+1,preStart+leftCount,inStart,rootIndex-1);
        root.right=build(preStart+leftCount+1,preEnd,rootIndex+1,inEnd);
        return root;
    }
}
