import java.util.LinkedList;
import java.util.List;

public class lc_93 {
    String s;
    List<String> result=new LinkedList<>();
    int[] segment=new int[4];
    public List<String> restoreIpAddresses(String s) {
        if (s==null){
            return result;
        }
        this.s=s;
        dfs(0,0);
        return result;
    }
    private void dfs(int start,int pointCount){
        if (pointCount==3){
            //校验最后一个数
            if (check(start,s.length()-1)){
                StringBuilder builder=new StringBuilder();
                for (int i=0;i<3;i++){
                    builder.append(segment[i]).append('.');
                }
                builder.append(s.substring(start,s.length()));
                result.add(builder.toString());
            }
            return;
        }
        int num=0;
        for (int i=start;i<s.length();i++){
            num=num*10+(s.charAt(i)-'0');
            if (num>255){
                break;
            }
            if (check(start,i)){
                segment[pointCount]=num;
            }else {
                continue;
            }
            dfs(i+1,pointCount+1);
        }
    }
    private boolean check(int start,int end){
        if (start>end){
            return false;
        }
        if (s.charAt(start)=='0'&&start!=end){
            return false;
        }
        int num=0;
        for (int i=start;i<=end;i++){
            num=num*10+(s.charAt(i)-'0');
            if (num>255){
                return false;
            }
        }
        return true;
    }
}
