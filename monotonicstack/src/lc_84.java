import java.util.Deque;
import java.util.LinkedList;

public class lc_84 {
    public static void main(String[] args) {
        new lc_84().largestRectangleArea2(new int[]{2,4});
    }
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

    public int largestRectangleArea2(int[] heights) {
        int n=heights.length;
        Deque<Integer> stack=new LinkedList<>();
        stack.addFirst(0);
        //头尾预留一个高度为0的柱子，防止单调递增或者单调递减的数组出现
        int[] arr=new int[n+2];
        for(int i=0;i<n;i++){
            arr[i+1]=heights[i];
        }
        int result=0;
        for(int i=1;i<=n+1;i++){
            if(arr[i]==arr[stack.peekFirst()]){
                //因为我们要找的是左右两侧最近的一个低于height[i]的柱子，所以遇到等高的，直接用新值
                stack.removeFirst();
                stack.addFirst(i);
            }else if(arr[i]>arr[stack.peekFirst()]){
                stack.addFirst(i);
            }else{
                while(!stack.isEmpty()&&arr[i]<arr[stack.peekFirst()]){
                    //找到mid两侧最近的小于mid的柱子
                    Integer mid=stack.removeFirst();
                    if(!stack.isEmpty()){
                        Integer left=stack.peekFirst();
                        result=Math.max(result,(i-left-1)*arr[mid]);
                    }
                }
                stack.addFirst(i);
            }
        }
        return result;
    }
}
