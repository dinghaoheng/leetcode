import java.util.Deque;
import java.util.LinkedList;

public class lc_394 {
    public static void main(String[] args) {
    }
    private class Pair{
        int k;
        String str;
        public Pair(int k,String str){
            this.k=k;
            this.str=str;
        }
    }
    public String decodeString(String s) {
        Deque<Pair> stack=new LinkedList<>();
        StringBuilder result=new StringBuilder();
        int k=0;
        for(char item : s.toCharArray()){
            if(Character.isLetter(item)){
                result.append(item);
            }else if (Character.isDigit(item)){
                //这里k的处理是为了处理多位数的情况，所以需要乘以10，而不是直接赋值
                k=k*10+(item-'0');
            }else if (item=='['){
                //保存当时的现场
                stack.addFirst(new Pair(k,result.toString()));
                result.setLength(0);
                k=0;
            }else{
                Pair pair=stack.removeFirst();
                StringBuilder builder=new StringBuilder();
                for(int i=0;i<pair.k;i++){
                    builder.append(result);
                }
                result=new StringBuilder(pair.str).append(builder);
            }
        }
        return result.toString();
    }
}
