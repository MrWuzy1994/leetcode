package leetcode.lc01000.lc0100;

public class Lc0058 {

    public int lengthOfLastWord(String s) {
        String[] s1 = s.split(" ");
        if (s1.length < 1){
            return 0;
        }
        return s1[s1.length-1].length();
    }

    public static void main(String[] args) {
        Lc0058 lc0058 = new Lc0058();
        System.out.println(lc0058.lengthOfLastWord(" "));
    }

}
