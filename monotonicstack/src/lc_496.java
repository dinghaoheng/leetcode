import java.util.*;

public class lc_496 {
    public static void main(String[] args) {

    }
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result=new int[nums1.length];
        Arrays.fill(result,-1);
        Map<Integer,Integer> map=new HashMap<>();
        for (int i=0;i<nums1.length;i++){
            map.put(nums1[i],i);
        }
        Deque<Integer> stack=new LinkedList<>();
        stack.addFirst(nums2[0]);
        for (int i=1;i<nums2.length;i++){
            if (nums2[i]<=stack.peekFirst()){
                stack.addFirst(nums2[i]);
            }else {
                while (!stack.isEmpty()&&nums2[i]>stack.peekFirst()){
                    Integer num=stack.removeFirst();
                    if (map.containsKey(num)){
                        Integer idx=map.get(num);
                        result[idx]=nums2[i];
                    }
                }
                stack.addFirst(nums2[i]);
            }
        }
        return result;
    }
}
