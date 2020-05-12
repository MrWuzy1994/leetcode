package leetcode.lc01000.lc0100;

public class Lc0026 {
    public int removeDuplicates(int[] nums) {
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0){
                left ++;
                continue;
            }
            if (nums[i] != nums[left-1]){
                nums[left] = nums[i];
                left ++;
            }
        }
        return left;
    }
}
