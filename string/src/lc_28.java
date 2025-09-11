public class lc_28 {

    public static void main(String[] args) {
    }

    public int strStr(String haystack, String needle) {
        if (needle.length()==0||needle.length()>haystack.length()){
            return -1;
        }
        //指向文本串
        int i=0;
        //指向模式串
        int j=0;
        int[] next=getNext(needle);
        for (;i<haystack.length();i++){
            //while遍历，直到i和j可以匹配
            while (j>0&&haystack.charAt(i)!=needle.charAt(j)){
                j=next[j-1];
            }
            if (haystack.charAt(i)==needle.charAt(j)){
                j++;
            }
            if (j==needle.length()){
                return i-needle.length()+1;
            }
        }
        return -1;
    }
    private int[] getNext(String str){
        int[] result=new int[str.length()];
        //前缀的末尾
        int j=0;
        //后缀的末尾
        int i=1;
        result[0]=j;
        for (;i<str.length();i++){
            //while循环，直到i和j可以匹配
            while (j>0&&str.charAt(i)!=str.charAt(j)){
                j=result[j-1];
            }
            if (str.charAt(i)==str.charAt(j)){
                j++;
            }
            result[i]=j;
        }
        return result;
    }
}
