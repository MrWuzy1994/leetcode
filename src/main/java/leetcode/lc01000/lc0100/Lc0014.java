package leetcode.lc01000.lc0100;

public class Lc0014 {

    public static void main(String[] args) {
        Solution0014 solution0014 = new Solution0014();
        System.out.println(solution0014.longestCommonPrefix(new String[]{"123", ""}));
    }
}



class Solution0014 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0){
            return "";
        }
        //取第一个字符串进行比较
        String first = strs[0];
        int i = 0; //表示公共部分字符串的长度
        firstFor:
        //通过第一个字符串,比较每一个字符
        for (; i < first.length(); i++) {
            //从数组中的第二个字符串开始比较,比较第i个位置的字符是否相等
            for (int j = 1; j < strs.length; j++) {
                //比较数组中第j个字符串的第i个字符是否和第一个字符串的
                if (i < strs[j].length() && strs[j].charAt(i) == first.charAt(i)){
                    //想等,比较下一个
                    continue;
                }
                //跳出循环的条件,1当前字符串的长度已经达到最大值,2字符不相等
                break firstFor;
            }
        }
        //返回最大公共子串
        return first.substring(0,i);
    }
}