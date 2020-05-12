package leetcode.lc01000.lc0100;

import java.util.*;

public class Lc0017 {

    private static Map<Character,String> allMap = new HashMap<>();
    static {
        allMap.put('2',"abc");
        allMap.put('3',"def");
        allMap.put('4',"ghi");
        allMap.put('5',"jkl");
        allMap.put('6',"mno");
        allMap.put('7',"pqrs");
        allMap.put('8',"tuv");
        allMap.put('9',"wxyz");
    }

    public List<String> allResult = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0)
            return allResult;
        zuhe(0,digits,"");
        return allResult;
    }

    public void zuhe(int index,String digits,String suffer){
        String currentStr = allMap.get(digits.charAt(index));
        if (index == digits.length() - 1){
            for (int i = 0; i < currentStr.length(); i++) {
                allResult.add(suffer+currentStr.charAt(i));
            }
        }else{
            for (int i = 0; i < currentStr.length(); i++) {
                zuhe(index + 1 ,digits,suffer + currentStr.charAt(i));
            }
        }
    }





}
