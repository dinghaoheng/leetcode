import java.util.*;

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

    public boolean isValid2(String s) {
        char[] arr=s.toCharArray();
        Deque<Character> stack=new LinkedList<>();
        Map<Character,Character> map=new HashMap(3,1);
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');
        for(int i=0;i<arr.length;i++){
            if(map.containsKey(arr[i])){
                if(stack.isEmpty()){
                    return false;
                }
                Character value=map.get(arr[i]);
                Character stackValue=stack.removeFirst();
                if(!stackValue.equals(value)){
                    return false;
                }
            }else{
                stack.addFirst(arr[i]);
            }
        }
        return stack.isEmpty();
    }
}
