import java.util.ArrayDeque;
import java.util.Deque;

public class lc_151 {
    public String reverseWords(String s) {
        int l=0;
        int r=s.length()-1;
        while (s.charAt(l)==' '){
            l++;
        }
        while (s.charAt(r)==' '){
            r--;
        }
        Deque<String> deque=new ArrayDeque<>();
        StringBuilder builder=new StringBuilder();
        while (l<=r){
            char item=s.charAt(l);
            if (item!=' '){
                builder.append(item);
            }else if (builder.length()>0){
                deque.addFirst(builder.toString());
                builder.setLength(0);
            }
            l++;
        }
        deque.addFirst(builder.toString());
        return String.join(" ",deque);
    }
}
