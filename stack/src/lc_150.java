import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: DHH
 * @Description:
 * @Modified By:
 * @Date: 2025/9/141:38
 * @Version:
 */
public class lc_150 {
    public static void main(String[] args) {
        evalRPN(new String[]{"4","13","5","/","+"});
    }

    public static int evalRPN(String[] tokens) {
        Set<String> set = new HashSet<>();
        set.add("+");
        set.add("-");
        set.add("*");
        set.add("/");
        Deque<Integer> deque = new ArrayDeque<>();
        for (String token : tokens) {
            if (!set.contains(token)) {
                deque.addFirst(Integer.parseInt(token));
                continue;
            }
            Integer result = null;
            Integer first = deque.removeFirst();
            Integer second = deque.removeFirst();
            if ("+".equals(token)) {
                result = second + first;
            } else if ("-".equals(token)) {
                result = first - second;
            } else if ("*".equals(token)) {
                result = first * second;
            } else {
                result = first / second;
            }
            deque.addFirst(result);
        }
        return deque.removeFirst();
    }
}
