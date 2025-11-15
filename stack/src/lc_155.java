import java.util.ArrayDeque;
import java.util.Deque;

public class lc_155 {
    Deque<int[]> stack=new ArrayDeque<>();
    public lc_155() {
        stack.addFirst(new int[]{0,Integer.MAX_VALUE});
    }

    public void push(int val) {
        //每次push元素，保存前缀最小值
        //preMin[i]=nums[0]到nums[i]的最小值
        int preMin=Math.min(getMin(),val);
        stack.addFirst(new int[]{val,preMin});
    }

    public void pop() {
        stack.removeFirst();
    }

    public int top() {
        return stack.peekFirst()[0];
    }

    public int getMin() {
        return stack.peekFirst()[1];
    }
}
