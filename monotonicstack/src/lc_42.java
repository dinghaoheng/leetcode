import java.util.Deque;
import java.util.LinkedList;

public class lc_42 {
    public static void main(String[] args) {
        new lc_42().trap2(new int[]{4, 2, 0, 3, 2, 5});
    }

    public int trap(int[] height) {
        int sum = 0;
        Deque<Integer> stack = new LinkedList<>();
        stack.addFirst(0);
        for (int i = 1; i < height.length; i++) {
            //和栈顶元素相同，则替换
            if (height[i] == height[stack.peekFirst()]) {
                stack.removeFirst();
                stack.addFirst(i);
            } else if (height[i] < height[stack.peekFirst()]) {
                stack.addFirst(i);
            } else {
                while (!stack.isEmpty() && height[i] > height[stack.peekFirst()]) {
                    Integer mid = stack.removeFirst();
                    if (!stack.isEmpty()) {
                        Integer left = stack.peekFirst();
                        Integer h = Math.min(height[left], height[i]) - height[mid];
                        Integer w = i - left - 1;
                        sum += h * w;
                    }
                }
                stack.addFirst(i);
            }
        }
        return sum;
    }

    public int trap2(int[] height) {
        int l=0;
        int r=height.length-1;
        //从左往右数的最大值
        int lMax=0;
        //从右往左数的最大值
        int rMax=0;
        int sum=0;
        while(l<r){
            lMax=Math.max(lMax,height[l]);
            rMax=Math.max(rMax,height[r]);
            //每个位置能接的雨水取决于这个位置左边的最大值和右边的最大值
            //取二中中较小的哪一个
            if(lMax<rMax){
                sum+=lMax-height[l++];
            }else{
                sum+=rMax-height[r--];
            }
        }
        return sum;
    }


}
