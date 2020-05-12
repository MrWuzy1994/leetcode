package leetcode.lc01000.lc0100;

import java.util.ArrayList;
import java.util.List;

public class Lc0006 {
    public String convert(String s, int numRows) {
        if (numRows == 1)
            return s;
        char[] chars = s.toCharArray();
        List<Character[]> results = new ArrayList<>();
        int point = 0;
        Character [] array = null;
        for (int i = 0; i < chars.length; i++) {
            if(point == 0){
                array = new Character[numRows];
                for (int j = 0; j < numRows && i < chars.length; j++) {
                    array[j] = chars[i++];
                }
                i--;
                results.add(array);
                point = numRows-2;
            }else{
                array = new Character[numRows];
                array[point] = chars[i];
                point --;
                results.add(array);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < results.size(); j++) {
                Character c = results.get(j)[i];
                if (c != null){
                    sb.append(c);
                }
            }
        }
        return  sb.toString();
    }

    public static void main(String[] args) {
        Lc0006 lc0005 = new Lc0006();
        System.out.println(lc0005.convert("LEETCODEISHIRING", 3));
    }
}
