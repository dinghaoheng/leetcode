import java.util.HashMap;
import java.util.Map;

public class lc_13 {
    public static void main(String[] args) {
        int i = new lc_13().romanToInt("III");
    }
    public int romanToInt(String s) {
        Map<Character,Integer> map=new HashMap<>(7,1.0f);
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int n=s.length();
        char[] arr=s.toCharArray();
        int sum=0;
        for(int i=0;i<n-1;i++){
            int curVal=map.get(arr[i]);
            int nextVal=map.get(arr[i+1]);
            //这种情况，需要减去curVal
            if(curVal<nextVal){
                sum=sum-curVal;
            }else{
                sum=sum+curVal;
            }
        }
        return sum+map.get(arr[n-1]);
    }

}
