import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

/**
 * @Author: DHH
 * @Description:
 * @Modified By:
 * @Date: 2025/9/141:13
 * @Version:
 */
public class lc_20 {
    /**
     * 注意边界条件的判断
     **/
    public boolean isValid(String s) {
        int len=s.length();
        if (len%2!=0){
            return false;
        }
        HashMap<Character,Character> map=new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
        Deque<Character> stack=new ArrayDeque<>();
        for (char item : s.toCharArray()) {
            Character mapItem=map.get(item);
            if (mapItem!=null){
                if (stack.isEmpty()){
                    return false;
                }
                Character stackItem=stack.removeFirst();
                if (!stackItem.equals(mapItem)){
                    return false;
                }
            }else {
                stack.addFirst(item);
            }
        }
        return stack.isEmpty();
    }
}
