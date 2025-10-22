import java.util.ArrayDeque;
import java.util.Deque;

public class lc_739 {
    public static void main(String[] args) {
        new lc_739().dailyTemperatures(new int[]{73,74,75,71,69,72,76,73});
    }
    public int[] dailyTemperatures(int[] temperatures) {
        int len=temperatures.length;
        int[] result=new int[len];
        Deque<Integer> stack=new ArrayDeque<>();
        stack.addFirst(0);
        for (int i=1;i<len;i++){
            if (temperatures[i]<=temperatures[stack.peekFirst()]){
                stack.addFirst(i);
            }else {
                while (!stack.isEmpty()&&temperatures[i]>temperatures[stack.peekFirst()]){
                    Integer item=stack.removeFirst();
                    result[item]=i-item;
                }
                stack.addFirst(i);
            }
        }
        return result;
    }
}
