import java.util.LinkedList;
import java.util.List;

public class lc_68 {
    public static void main(String[] args) {
        String[] arr=new String[]{"What","must","be","acknowledgment","shall","be"};
        new lc_68().fullJustify(arr,16);
    }
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result=new LinkedList<>();
        int n=words.length;
        int end=0;
        while(end<n){
            int start=end;
            int len=words[start].length();
            end++;
            while(end<n&&len+words[end].length()+1<=maxWidth){
                len+=words[end].length()+1;
                end++;
            }
            int leftSpace=maxWidth-len;
            int gaps=end-start-1;
            //处理最后一行，或者只有一个单词的行，末端加空格即可
            if(gaps==0||end>=n){
                //单词间用一个空格相隔
                StringBuilder row=join(words,start,end," ");
                for(int i=0;i<leftSpace;i++){
                    row.append(" ");
                }
                result.add(row.toString());
                continue;
            }
            //处理一般情况
            //每个间隔有多少个空格
            int spaceCount=leftSpace/gaps;
            //有多少个间隔多出一个空格
            int remain=leftSpace%gaps;
            StringBuilder baseSpace=new StringBuilder();
            //每一行多出一个空格，因为前面计数时，默认加了一个空格
            for(int i=0;i<=spaceCount;i++){
                baseSpace.append(" ");
            }
            StringBuilder row=join(words,start,start+remain+1,baseSpace.toString()+" ");
            row.append(baseSpace);
            row.append(join(words,start+remain+1,end,baseSpace.toString()));
            result.add(row.toString());
        }
        return result;
    }
    private StringBuilder join(String[] words,int start,int end,String space){
        StringBuilder result=new StringBuilder();
        for(int i=start;i<end;i++){
            if(i!=start){
                result.append(space);
            }
            result.append(words[i]);
        }
        return result;
    }

}
