import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {
        new test().hIndex(new int[]{1,3,1});
        List<Integer> list=new ArrayList<>();

    }
    public int hIndex(int[] citations) {
        int n=citations.length;
        int[] map=new int[n+1];
        for(int i=0;i<n;i++){
            int count=citations[i];
            //这里在n和应用次数之间去最小，目的在于防止越界，理由是次数超过了n没有意义
            map[Math.min(n,count)]++;
        }
        int sum=0;
        for(int i=n;i>=0;i--){
            sum+=map[i];
            if(sum>=i){
                return sum;
            }
        }
        return -1;
    }
}
