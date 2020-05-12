package leetcode.lc01000.lc0100;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Lc0007 {
    public static void main(String[] args) {
    }

    public static int reverse(int x) {
        long result = 0L;
        while (x != 0){
            result = result * 10 +x%10;
            x /= 10;
        }
        if (result < Integer.MIN_VALUE || result > Integer.MAX_VALUE){
            return 0;
        }
        return (int)result;
    }

    public static boolean fun(String str){
        int left = 0;
        int right = str.length() - 1;
        while (left < right){
            if (str.charAt(left) != str.charAt(right)){
                return false;
            }
            left ++;
            right --;
        }
        return true;
    }

    public static void fun2(String str){
        Map<Character,Integer> result = new LinkedHashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            Integer num = result.get(c);
            if (num == null){
                result.put(c,1);
            }else{
                result.put(c,result.get(c)+1);
            }
        }
        printMsg(result);
    }

    public static void printMsg(Map<Character,Integer> result){
        Set<Character> characters = result.keySet();
        for (Character c:characters ) {
            System.out.print(c + " " + result.get(c) + " ");
        }
    }
}
