import java.util.HashMap;
import java.util.Map;

public class lc_904 {
    //与209不同的是，904需要结果尽可能的大，所以在超出限制的时候，移除元素
    //209是需要结果尽可能的消，所以在满足条件的时候，移除元素
    public int totalFruit(int[] fruits) {
        Map<Integer,Integer> basket=new HashMap<>();
        int l=0;
        int length=Integer.MIN_VALUE;
        for (int r=0;r<fruits.length;r++){
            int count=basket.getOrDefault(fruits[r],0);
            basket.put(fruits[r],count+1);
            while (basket.size()>2){
                int leftCount=basket.get(fruits[l]);
                if (leftCount==1){
                    basket.remove(fruits[l]);
                }else {
                    basket.put(fruits[l],leftCount-1);
                }
                l++;
            }
            length=Math.max(length,(r-l+1));
        }
        return length;
    }
}
