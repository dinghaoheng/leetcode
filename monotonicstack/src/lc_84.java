import java.util.Deque;
import java.util.LinkedList;

public class lc_84 {
    public int largestRectangleArea(int[] heights) {
        int sum = 0;
        Deque<Integer> stack = new LinkedList<>();
        stack.addFirst(0);
        //与接雨水不同，需要在头尾各加一个0，让所有元素都可以参与判断
        int[] arr = new int[heights.length + 2];
        for (int i = 0; i < heights.length; i++) {
            arr[i + 1] = heights[i];
        }
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[stack.peekFirst()]) {
                stack.removeFirst();
                stack.addFirst(i);
            } else if (arr[i] > arr[stack.peekFirst()]) {
                stack.addFirst(i);
            } else {
                while (!stack.isEmpty() && arr[i] < arr[stack.peekFirst()]) {
                    Integer mid = stack.removeFirst();
                    if (!stack.isEmpty()) {
                        Integer left = stack.peekFirst();
                        sum = Math.max(sum, (i - left - 1) * arr[mid]);
                    }
                }
                stack.addFirst(i);
            }
        }
        return sum;
    }
}
