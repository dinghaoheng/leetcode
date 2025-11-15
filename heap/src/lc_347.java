import java.util.*;

public class lc_347 {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<int[]> queue=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        Map<Integer,Integer> map=new HashMap<>();
        for (int num : nums) {
            Integer count = map.getOrDefault(num, 0);
            map.put(num,count+1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer key=entry.getKey();
            Integer value=entry.getValue();
            if (queue.size()<k){
                queue.add(new int[]{key,value});
            }else if (value>queue.peek()[1]){
                queue.poll();
                queue.add(new int[]{key,value});
            }
        }
        int[] result=new int[k];
        int idx=0;
        for (int i=0;i<k;i++){
            result[idx++]=queue.poll()[0];
        }
        return result;
    }

    public static void main(String[] args) {
        lc_347 lc347 = new lc_347();
        lc347.topKFrequent3(new int[]{1,1,1,2,2,3},2);
    }

    public int[] topKFrequent2(int[] nums, int k) {
        PriorityQueue<int[]> queue=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        int len=nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i=0;i<len ;i++) {
            Integer count=map.getOrDefault(nums[i],0);
            map.put(nums[i],count+1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer key=entry.getKey();
            Integer value=entry.getValue();
            if (queue.size()<k){
                queue.add(new int[]{key,value});
            }else if (queue.peek()[1]<value){
                queue.remove();
                queue.add(new int[]{key,value});
            }
        }
        int[] result=new int[k];
        int idx=0;
        for (int i=0;i<k;i++){
            int[] item=queue.remove();
            result[idx++]=item[0];
        }
        return result;
    }

    public int[] topKFrequent3(int[] nums, int k) {
        int max=0;
        Map<Integer,Integer> map=new HashMap<>();
        for(int item : nums){
            Integer count=map.getOrDefault(item,0)+1;
            map.put(item,count);
            max=Math.max(max,count);
        }
        List<Integer> [] buckets=new ArrayList[max+1];
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            Integer num=entry.getKey();
            Integer freq=entry.getValue();
            if(buckets[freq]==null){
                buckets[freq]=new ArrayList<>();
            }
            buckets[freq].add(num);
        }
        int[] result=new int[k];
        int idx=0;
        for(int i=max;i>=0&&idx<k;i++){
            if(buckets[i]==null){
                continue;
            }
            for(Integer item : buckets[i]){
                result[idx++]=item;
            }
        }
        return result;
    }
}
