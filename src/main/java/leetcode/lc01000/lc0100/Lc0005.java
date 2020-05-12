package leetcode.lc01000.lc0100;

public class Lc0005 {
    
    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        String max = "";
        for (int i = 0; i < chars.length; i++) {
            int left = i;
            int right = i + 1;
            while (left >= 0 && right < chars.length && chars[left] == chars[right]){
                left --;
                right ++;
            }

            while (left >= 0 && right < chars.length && chars[left] == chars[right]){
                left --;
                right ++;
            }

        }
        return null;
    }
    
}
