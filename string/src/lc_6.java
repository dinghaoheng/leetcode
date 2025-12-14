public class lc_6 {

    public String convert(String s, int numRows) {
        if(numRows<=1){
            return s;
        }
        StringBuilder[] row=new StringBuilder[numRows];
        for(int i=0;i<numRows;i++){
            row[i]=new StringBuilder();
        }
        int idx=0;
        //在头尾行需要转向
        int flag=-1;
        for(int i=0;i<s.length();i++){
            row[idx].append(s.charAt(i));
            if(idx==0||idx==numRows-1){
                flag=-flag;
            }
            idx+=flag;
        }
        StringBuilder result=new StringBuilder();
        for(int i=0;i<numRows;i++){
            result.append(row[i]);
        }
        return result.toString();
    }
}
