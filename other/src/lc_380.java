import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class lc_380 {
    HashMap<Integer,Integer> map;
    List<Integer> list;
    Random random;
    public lc_380() {
        map=new HashMap<>();
        list=new ArrayList<>();
        random=new Random();
    }

    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }
        map.put(val,list.size());
        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        //删除元素时，如果直接删除，会导致map中的索引错误
        //所以要用最后一个元素去覆盖这个目标数，再删除最后一个元素，防止前面的数索引变化
        if(!map.containsKey(val)){
            return false;
        }
        Integer index=map.remove(val);
        Integer lastNum=list.get(list.size()-1);
        //更新数组和map
        list.set(index,lastNum);
        map.put(lastNum,index);
        list.remove(list.size()-1);
        map.remove(val);
        return true;
    }

    public int getRandom() {
        int idx=random.nextInt(list.size());
        return list.get(idx);
    }
}
