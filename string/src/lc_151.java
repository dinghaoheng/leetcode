import java.util.Deque;
import java.util.LinkedList;

public class lc_151 {

    public static void main(String[] args) {
        new lc_151().reverseWords("a good   example");
    }
    public String reverseWords(String s) {
        int l=0;
        int r=s.length()-1;
        while(s.charAt(l)==' '){
            l++;
        }
        while(s.charAt(r)==' '){
            r--;
        }
        //从头部插入字符串，保证倒序
        Deque<String> deque=new LinkedList<>();
        StringBuilder builder=new StringBuilder();
        for(;l<=r;l++){
            if(s.charAt(l)!=' '){
                builder.append(s.charAt(l));
            }else if(builder.length()!=0){
                //这里需要添加判断，防止连续的空串
                deque.addFirst(builder.toString());
                builder.setLength(0);
            }
        }
        //加入最后一个单词
        deque.addFirst(builder.toString());
        StringBuilder result=new StringBuilder();
        while(!deque.isEmpty()){
            result.append(deque.removeFirst());
            if(!deque.isEmpty()){
                result.append(' ');
            }
        }
        return result.toString();
    }
}
