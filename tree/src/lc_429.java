
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class lc_429 {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result=new ArrayList<>();
        if (root==null){
            return result;
        }
        Deque<Node> queue=new ArrayDeque<>();
        queue.addFirst(root);
        while (!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int size=queue.size();
            for (int i=0;i<size;i++){
                Node node= queue.removeLast();
                list.add(node.val);
                if (node.children!=null){
                    for (Node item : node.children){
                        queue.addFirst(item);
                    }
                }
            }
            result.add(list);
        }
        return result;
    }

}
