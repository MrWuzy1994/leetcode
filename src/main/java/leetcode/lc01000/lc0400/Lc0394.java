package leetcode.lc01000.lc0400;

import java.util.Stack;

public class Lc0394 {


    /**
     * 遍历字符串，
     *      遇到数字，字母，'['  进行入栈
     *      遇到 ']'  对栈中元素进行出栈操作，直到出栈到'['
     *      出栈'['前的数字，拼接自字符串，拼接完成以后把拼接完成的字符串入栈
     *
     *      最后把栈中的元素拼接成字符串，返回
     * @param s
     * @return
     */
    public String decodeString(String s) {
        //判断字符串长度，不合法则直接返回
        if (s == null || s.length() < 1){
            return s;
        }
        //获取字符串的char数组
        char[] chars = s.toCharArray();
        //栈元素定义
        Stack<String> stack = new Stack<>();
        //遍历元素数组，对数组元素进行出栈入栈操作
        for (int i = 0; i < chars.length; i++) {
            //0-9，[，a-z 入栈
            if (('0' <= chars[i] && '9' >= chars[i]) || chars[i] == '[' || ('a' <= chars[i] && 'z' >= chars[i]) || ('A' <= chars[i] && 'Z' >= chars[i])){
                stack.push(String.valueOf(chars[i]));
            }else if (chars[i] == ']'){
                //遇到']' 说明前面入栈元素有一个和他对应的[ ，出栈字符
                String str = "";
                //需要出栈
                while (true){
                    String peek = stack.peek();
                    if (!"[".equals(peek)){
                        //判断栈顶元素是不是 [  如果不是说明是正常的字符，则拼接字符
                        str = stack.pop() +str;
                    }else{
                        // [ 字符出栈
                        stack.pop();
                        //数字出栈，由于数字多位数，全部出栈
                        String number = "";
                        //数字出栈
                        while (stack.size() > 0){
                            String pop = stack.peek();
                            if('0' <= pop.charAt(0) && '9' >= pop.charAt(0)){
                                number = stack.pop() + number;
                            }else{
                                break;
                            }
                        }
                        //数字转换为int，拼接n个字符
                        int n = Integer.parseInt(number);
                        String temp = "";
                        for (int j = 0; j < n; j++) {
                            temp += str;
                        }
                        //拼接完成以后入栈
                        if (n > 0)
                            stack.push(temp);
                        break;
                    }
                }
            }
        }
        String str = "";
        //栈中元素拼接为字符串，返回
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            str = stack.pop() + str;
        }
        return str;
    }

    public static void main(String[] args) {
        Lc0394 lc0394 = new Lc0394();
        System.out.println(lc0394.decodeString("2[abc]3[cd]ef"));
    }
}
