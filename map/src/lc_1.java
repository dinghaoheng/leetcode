import java.util.HashMap;
import java.util.Map;

/**
 * @Author: DHH
 * @Description:
 * @Modified By:
 * @Date: 2025/9/1023:23
 * @Version:
 */
public class lc_1
{
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int i=0;i<nums.length;i++){
            int item=nums[i];
            int dif=target-item;
            if (map.containsKey(dif)){
                return new int[]{i,map.get(dif)};
            }
            map.put(item,i);
        }
        return new int[2];
    }

}
