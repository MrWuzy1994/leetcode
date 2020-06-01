package leetcode.lc02000;

import java.util.HashSet;
import java.util.Set;

public class Lc1456 {

    public int maxVowels(String s, int k) {
        if (s.length() == 0 || k < 1){
            return 0;
        }
        int max = 0;
        for (int i = 0; i < k && i < s.length(); i++) {
            if (isYuanyin(s.charAt(i))){
                max ++;
            }
        }

        int temp = max;
        for (int i = k; i < s.length(); i++) {
            //判断头一个是不是原因
            if (isYuanyin(s.charAt(i - k))){
                temp --;
            }
            //判断当前是不是原因
            if (isYuanyin(s.charAt(i))){
                temp ++;
            }
            max = Math.max(temp, max);
            if (max == k)
                return max;
        }
        return  max;


    }

    public boolean isYuanyin(Character c){
        if (  c == 'a' ||
                c == 'e' ||
                c == 'i' ||
               c == 'o' ||
               c == 'u' )
            return true;
        return false;
    }


    public static void main(String[] args) {
        Lc1456 lc1456 = new Lc1456();
        lc1456.maxVowels("aeiou",2);
    }
}
