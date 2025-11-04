import java.util.HashMap;
import java.util.Map;

public class lc_560 {
    public static void main(String[] args) {
        new lc_560().subarraySum2(new int[]{1,1,-1,1,-1},1);
    }
    public int subarraySum2(int[] nums, int k) {
        int len=nums.length;
        int[] sumArr=new int[len+1];
        int sum=0;
        for(int i=1;i<len;i++){
            sum+=nums[i-1];
            sumArr[i]=sum;
        }
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int res=0;
        for(int i=0;i<len;i++){
            int sum1=sumArr[i+1];
            int target=sum1-k;
            res+=map.getOrDefault(target,0);
            int count=map.getOrDefault(sum1,0);
            map.put(sum1,count+1);
        }
        return res;
    }

    public int subarraySum(int[] nums, int k) {
        int n=nums.length;
        Map<Integer,Integer> map=new HashMap<>(n+1,1);
        //空集的和为0
        map.put(0,1);
        int result=0;
        int sum=0;
        for(int item : nums){
            sum+=item;
            result+=map.getOrDefault(sum-k,0);
            map.merge(sum, 1, Integer::sum);
        }
        return result;
    }
}
