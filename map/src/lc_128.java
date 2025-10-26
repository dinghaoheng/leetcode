import java.util.HashSet;
import java.util.Set;

public class lc_128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for (int item : nums){
            set.add(item);
        }
        int result=0;
        //这里需要遍历set，而不是原数组，因为原数组包含重复元素
        for (int item : set){
            //判断该数是否是一个新的开始
            if (!set.contains(item-1)){
                int curNum=item;
                int curLen=1;
                while (set.contains(curNum+1)){
                    curNum++;
                    curLen++;
                }
                result=Math.max(result,curLen);
            }
        }
        return result;
    }
}
