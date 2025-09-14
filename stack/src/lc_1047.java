import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: DHH
 * @Description:
 * @Modified By:
 * @Date: 2025/9/141:24
 * @Version:
 */
public class lc_1047 {
    /**
     * 可以直接使用stringBuilder作为栈
     **/
    public String removeDuplicates(String s) {
        Deque<Character> deque=new ArrayDeque<>();
        for (char item : s.toCharArray()) {
            if (!deque.isEmpty()&&deque.peekFirst().equals(item)){
                deque.removeFirst();
            }else {
                deque.addFirst(item);

            }
        }
        StringBuilder builder=new StringBuilder();
        while (!deque.isEmpty()){
            builder.append(deque.removeLast());
        }
        return builder.toString();
    }
}
