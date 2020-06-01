
package leetcode.lc01000.Lc0800;

import java.util.ArrayList;
import java.util.List;

public class Lc0784 {

    public List<String> letterCasePermutation(String S) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dg(list,S,0,sb);
        return list;
    }

    public void dg(List<String> results,String str,int i,StringBuilder sb){
        if (i == str.length() ){
            results.add(sb.toString());
            return;
        }
        sb.append(str.charAt(i));
        dg(results,str,i + 1,sb);
        sb.deleteCharAt(i);
        if (str.charAt(i) <= 'z' && str.charAt(i) >= 'a'){
            sb.append(String.valueOf(str.charAt(i)).toUpperCase());
            dg(results,str,i + 1,sb);
            sb.deleteCharAt(i);
        }else if (str.charAt(i) <= 'Z' && str.charAt(i) >= 'A'){
            sb.append(String.valueOf(str.charAt(i)).toLowerCase());
            dg(results,str,i + 1,sb);
            sb.deleteCharAt(i);
        }


    }

    public static void main(String[] args) {
        Lc0784 lc0784 = new Lc0784();
        lc0784.letterCasePermutation("a1b2");
    }
}
