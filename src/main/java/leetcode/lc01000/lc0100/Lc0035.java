package leetcode.lc01000.lc0100;

public class Lc0035 {
    
    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target){
                return i;
            }
        }
        return nums.length ;
    }
    
}
