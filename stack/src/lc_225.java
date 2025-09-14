import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: DHH
 * @Description:
 * @Modified By:
 * @Date: 2025/9/141:04
 * @Version:
 */
public class lc_225 {
    /**
     * 每次存入元素的时候，将N-1个元素倒转顺序，使先入后出变为先入先出
     **/
    private Deque<Integer> list=new ArrayDeque<>();
    public lc_225() {

    }

    public void push(int x) {
        list.addFirst(x);
        for (int i=0;i<list.size()-1;i++){
            list.addFirst(list.removeLast());
        }
    }

    public int pop() {
        return list.removeLast();
    }

    public int top() {
        return list.peekLast();
    }

    public boolean empty() {
        return list.isEmpty();
    }
}
