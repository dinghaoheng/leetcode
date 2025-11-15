import java.util.PriorityQueue;

public class lc_295 {
    private final PriorityQueue<Integer> left =new PriorityQueue<>((a,b)->b-a);
    private final PriorityQueue<Integer> right=new PriorityQueue();
    public lc_295() {

    }

    //需要兼容奇数元素的情况，数量left>=right
    public void addNum(int num) {
        if(left.size()==right.size()){
            right.offer(num);
            left.offer(right.poll());
        }else{
            left.offer(num);
            right.offer(left.poll());
        }
    }

    public double findMedian() {
        if(left.size()==right.size()){
            return (left.peek()+right.peek())/2.0;
        }else{
            return left.peek();
        }
    }

}
