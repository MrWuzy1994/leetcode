package leetcode.lc01000.lc0700;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Lc0680 {

    public boolean validPalindrome(String s) {
        if (isHuiwen(s))
            return true;
        for (int i = 0; i < s.length(); i++) {
            if (isHuiwen(s.substring(0,i) + s.substring(i+1,s.length()))){
                return true;
            }
        }
        return false;
    }

    public boolean isHuiwen(String string){
        char[] chars = string.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        while ( left < right){
            if (chars[left++] != chars[right--])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {

        //最开始调用的时候要m+1，因为题目的第一列实际对应杨辉三角的第二列
        //如  n = 5， m=6

        System.out.println(dieCi("李李冰冰太太"));
    }

    static int f(int n,int m){
        if(n==m||m==1)
            return 1;
        else
            return f(n-1,m-1)+f(n-1,m);
    }

    static Set<String> dieCi(String str){
        if (str == null || str.length() < 1)
            return null;

        Set<String> set = new HashSet<>();
        for (int i = 0; i < str.length() - 1; i++) {
            int temp = str.charAt(i);
            if (temp == str.charAt(i + 1)){
                int start = i;
                while ( ++i < str.length() - 1 &&  str.charAt(i) == temp);
                set.add(str.substring(start,i));
                if (i >= str.length() -1)
                    break;
            }
        }
        return set;
    }
}
