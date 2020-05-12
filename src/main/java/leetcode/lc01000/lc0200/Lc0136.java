package leetcode.lc01000.lc0200;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Lc0136 {
    public int singleNumberMap(int[] nums) {
        if (nums.length < 1){
            return 0;
        }
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer integer = map.get(nums[i]);
            if (integer == null){
                integer = 1;
                map.put(nums[i],integer);
                continue;
            }
            map.put(nums[i],integer+1);
        }
        Set<Integer> keySet = map.keySet();
        for (Integer i:keySet
             ) {
            if (map.get(i) == 1){
                return i;
            }
        }
        return 0;
    }


    public int singleNumber(int []nums){
        if (nums.length < 1){
            return 0;
        }
        int num = nums[0];
        for (int i = 1; i < nums.length; i++) {
            num = num ^ nums[i];
        }
        return num;
    }
    public static void main(String[] args) {
        Lc0136 lc0136 = new Lc0136();
        lc0136.singleNumber(new int[]{4,1,2,1,2});
    }
}
