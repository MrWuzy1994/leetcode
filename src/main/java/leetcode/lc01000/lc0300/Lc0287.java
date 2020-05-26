package leetcode.lc01000.lc0300;

public class Lc0287 {

    public int findDuplicate(int[] nums) {
        if (nums.length < 2){
            return -1;
        }
        int [] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[nums[i]] += 1;
            if (  result[nums[i]] > 1){
                return nums[i];
            }
        }
        return 0;
    }
}
