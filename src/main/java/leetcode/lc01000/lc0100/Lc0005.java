package leetcode.lc01000.lc0100;

public class Lc0005 {

    public String longestPalindrome(String s) {
        if (s.length() == 0)
            return "";
        boolean a[][] = new boolean [s.length() ][s.length()];
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int right =  i;
            for (int j = 0; j < s.length() - i; j++) {
                if (j == right){
                    a[j][right] = true;
                }else if (j + 1 == right){
                    a[j][right] = s.charAt(j) == s.charAt(right);
                }else {
                    a[j][right] = a[j + 1][right - 1] &&  s.charAt(j) == s.charAt(right);
                }
                if (a[j][right] && start - end < right - j){
                    start = j;
                    end = right;
                }
                right ++;
            }
        }
        return s.substring(start,end+1);
    }
    
}
