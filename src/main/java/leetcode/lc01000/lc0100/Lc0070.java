package leetcode.lc01000.lc0100;

import java.util.HashMap;
import java.util.Map;

public class Lc0070 {
    private Map<Integer,Integer> result = new HashMap<>();
    public int climbStairs(int n) {
        if(n <= 1){
            return 1;
        }
        Integer num = result.get(n);
        if (num != null){
            return num;
        }
        int left = climbStairs(n - 1);
        int right = climbStairs(n - 2);
        int all = left + right;
        result.put(n,all);
        return  all;
    }

    public static void main(String[] args) {
        Lc0070 lc0070 = new Lc0070();

        System.out.println(lc0070.climbStairs(44));
    }
}
