package leetcode.lc01000.lc0100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lc0020 {
}

class Solution0020 {
    //闭合括号对应的开始括号
    private Map<Character,Character> map = new HashMap<>();
    {
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
    }
    public  boolean isValid(String s) {
        //模拟栈
        List<Character> stack = new ArrayList<>();
        //转变为char数组
        char[] chars = s.toCharArray();
        //遍历数组
        for (int i = 0; i < chars.length; i++) {
            //数组中当前符号
            Character current = chars[i];
            //如果是起始括号,则入栈
            if ( current == '(' || current == '[' || current == '{'){
                stack.add(chars[i]);
            }else{//闭合括号,则判断栈中的末尾符号,如果和当前符号对应,则出栈
                if (stack.size() - 1 >= 0 && (stack.get(stack.size() - 1) == map.get(current))){
                    stack.remove(stack.size() - 1);
                }else{
                    //不对应,返回false
                    return false;
                }
            }
        }
        //遍历玩char数组,如果栈中还有剩余元素,则说明字符串没有完全闭合,返回false
        if (stack.size() > 0){
            return false;
        }
        //正常,返回true
        return true;
    }
}
