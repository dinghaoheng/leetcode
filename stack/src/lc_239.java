import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;

/**
 * @Author: DHH
 * @Description:
 * @Modified By:
 * @Date: 2025/9/1418:24
 * @Version:
 */
public class lc_239 {


    /**
     * 维护优先队列，时间复杂度为nLogn
     **/
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len=nums.length;
        PriorityQueue<int[]> queue=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]==o2[0]?o2[1]-o1[1]:o2[0]-o1[0];
            }
        });
        int[] result=new int[len-k+1];
        int idx=0;
        for (int i=0;i<k;i++){
            queue.add(new int[]{nums[i],i});
        }
        result[idx++]=queue.peek()[0];
        for (int i=k;i<len;i++){
            queue.add(new int[]{nums[i],i});
            while (queue.peek()[1]<=i-k){
                queue.poll();
            }
            result[idx++]=queue.peek()[0];
        }
        return result;
    }

    /**
     * 单调队列，时间复杂度为n
     **/
    public int[] maxSlidingWindow2(int[] nums, int k) {
        int len=nums.length;
        Deque<Integer> deque=new ArrayDeque<>();
        int[] result=new int[len-k+1];
        int idx=0;
        for (int i=0;i<len;i++){
            //若位于头部的元素，超出范围，直接移除
            while (!deque.isEmpty()&&deque.peek()<=i-k){
                deque.removeFirst();
            }
            int num=nums[i];
            //移除尾部小于当前元素的元素，保持单调递增
            while (!deque.isEmpty()&&nums[deque.peekLast()]<=num){
                deque.removeLast();
            }
            deque.addLast(i);
            if (i>=k-1){
                result[idx++]=nums[deque.peek()];
            }
        }
        return result;
    }
}
