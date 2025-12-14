package palindrome;

public class lc_5 {
    public static void main(String[] args) {
        new lc_5().longestPalindrome2("cbbd");
    }

    /**
     * 中心扩散法，相较于pd，空间复杂度为o1
     */
    public String longestPalindrome2(String s) {
        int n=s.length();
        char[] arr=s.toCharArray();
        int left=0;
        int len=0;
        //求长度为奇数的回文串
        for(int i=0;i<n;i++){
            int l=i;
            int r=i;
            while(l>0&&r<n-1&&arr[l-1]==arr[r+1]){
                l--;
                r++;
            }
            if(r-l+1>len){
                len=r-l+1;
                left=l;
            }
        }
        //求长度为偶数的回文串
        for(int i=0;i<n;i++){
            int l=i;
            int r=i+1;
            if(r>=n||arr[l]!=arr[r]){
                continue;
            }
            while(l>0&&r<n-1&&arr[l-1]==arr[r+1]){
                l--;
                r++;
            }
            if(r-l+1>len){
                len=r-l+1;
                left=l;
            }
        }
        return s.substring(left,left+len);
    }


    public String longestPalindrome(String s) {
        int l=0;
        int r=0;
        int result=0;
        int len=s.length();
        boolean[][] dp=new boolean[len][len];
        for (int i=len-1;i>=0;i--){
            for (int j=i;j<len;j++){
                if (s.charAt(i)==s.charAt(j)){
                    if (j-i<=1){
                        dp[i][j]=true;
                    }else {
                        dp[i][j]=dp[i+1][j-1];
                    }
                    if (j-i+1>result&&dp[i][j]){
                        l=i;
                        r=j;
                        result=j-i+1;
                    }
                }
            }
        }
        return s.substring(l,r+1);
    }
}
