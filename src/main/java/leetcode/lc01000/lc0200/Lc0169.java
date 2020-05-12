package leetcode.lc01000.lc0200;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Lc0169 {

    public int majorityElement(int[] nums) {
        if (nums == null || nums.length < 1){
            return 0;
        }
        Map<Integer,Integer> m = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer num = m.get(nums[i]);
            if (num == null){
                m.put(nums[i],1);
            }else{
                m.put(nums[i] , num + 1);
            }
        }
        float midNum = nums.length / 2.0f;
        Set<Integer> integers = m.keySet();
        for (Integer i: integers  ) {
            if (m.get(i) > midNum){
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Lc0169 l = new Lc0169();

        System.out.println(l.majorityElement(new int[]{2, 3, 3}));
    }
}
