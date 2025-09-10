public class lc_844 {


    public static void main(String[] args) {
        String str1="ab#c";
        String str2="ab#c";
        backspaceCompare(str1,str2);
    }

    public static boolean backspaceCompare(String s, String t) {
        int i=s.length()-1;
        int j=t.length()-1;
        int sSpaceCount=0;
        int tSpaceCount=0;
        while (i>=0||j>=0){
            while (i>=0){
                if (s.charAt(i)=='#'){
                    i--;
                    sSpaceCount++;
                }else if (sSpaceCount>0){
                    sSpaceCount--;
                    i--;
                }else {
                    break;
                }
            }
            while (j>=0){
                if (t.charAt(j)=='#'){
                    j--;
                    tSpaceCount++;
                }else if (tSpaceCount>0){
                    tSpaceCount--;
                    j--;
                }else {break;}
            }
            if (i>=0&&j>=0){
                if (s.charAt(i)!=t.charAt(j)){
                    return false;
                }
            }else {
                if (i!=j){
                    return false;
                }
            }
        }
        return true;
    }
}

