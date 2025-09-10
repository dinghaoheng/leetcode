import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: DHH
 * @Description:
 * @Modified By:
 * @Date: 2025/9/1022:49
 * @Version:
 */
public class test {
    public static void main(String[] args) {
        intersect(new int[]{1,2,2,1},new int[]{2,2});
    }
    public static int[] intersect(int[] nums1, int[] nums2) {
        int len1=nums1.length;
        int len2=nums2.length;
        if (len2<len1){
            return intersect(nums2,nums1);
        }
        Map<Integer,Integer> map=new HashMap<>();
        for (int i : nums1) {
            int count=map.getOrDefault(i,0);
            map.put(count,i+1);
        }
        int[] res=new int[len1];
        int idx=0;
        for (int i : nums2) {
            Integer count=map.get(i);
            if (count==null){
                continue;
            }
            res[idx++]=i;
            if (count==1){
                map.remove(i);
            }else {
                map.put(i,count-1);
            }
        }
        return Arrays.copyOfRange(res,0,idx);
    }
}
