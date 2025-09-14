import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: DHH
 * @Description:
 * @Modified By:
 * @Date: 2025/9/140:34
 * @Version:
 */
public class lc_232 {
    private Deque<Integer> stackIn=new ArrayDeque<>();
    private Deque<Integer> stackOut=new ArrayDeque<>();

    public lc_232() {
    }

    public void push(int x) {
        stackIn.addFirst(x);
    }

    public int pop() {
        if (stackOut.isEmpty()){
            tranItem();
        }
        return stackOut.removeFirst();
    }

    public int peek() {
        if (stackOut.isEmpty()){
            tranItem();
        }
        return stackOut.peek();
    }

    public boolean empty() {
        return stackIn.isEmpty()&&stackOut.isEmpty();
    }
    private void tranItem(){
        while (!stackIn.isEmpty()){
            stackOut.addFirst(stackIn.removeFirst());
        }
    }
}
