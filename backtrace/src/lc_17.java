import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class lc_17 {
    List<String> result=new LinkedList<>();
    StringBuilder path=new StringBuilder();
    Map<Integer,String> map=new HashMap<>();
    char[] arr;
    public List<String> letterCombinations(String digits) {
        if (digits.length()==0){
            return result;
        }
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"nmo");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");
        arr=digits.toCharArray();
        dfs(0);
        return result;
    }
    private void dfs(int index){
        if (index==arr.length){
            result.add(path.toString());
            return;
        }
        String str=map.get(arr[index]-'0');
        for (int i=0;i<str.length();i++){
            path.append(str.charAt(i));
            dfs(index+1);
            path.deleteCharAt(path.length()-1);
        }
    }
}
