public class lc_14 {
    public static void main(String[] args) {
        new lc_14().longestCommonPrefix(new String[]{"flower","flow","flight"});
    }
    public String longestCommonPrefix(String[] strs) {
        String first=strs[0];
        //从左往右遍历
        for(int i=0;i<first.length();i++){
            char item=first.charAt(i);
            //从上往下遍历
            for(String str : strs){
                //此时可以判断出，i不是公共前缀
                //后续的字符串无需再判断，0,i-1是公共前缀
                if(i>=str.length()||item!=str.charAt(i)){
                    return first.substring(0,i);
                }
            }
        }
        return first;
    }
}
