package leetcode.lc01000.lc0100;

public class Lc0009 {
}

class Solution {
    public boolean isPalindrome(int x) {
        //转化为字符串
        String s = String.valueOf(x);
        //字符串左端开始字符
        int left = 0;
        //字符串右端开始字符
        int right = s.length() - 1;
        while ( left < right ){//到达中轴线,如果一直都相等,说明是回文数
            //比较当前左边和当前右边的字符是否相等
            if (s.charAt(left++) != s.charAt(right--)){
                //不相等,不是回文数
                return false;
            }
        }
        return true;
    }
}
