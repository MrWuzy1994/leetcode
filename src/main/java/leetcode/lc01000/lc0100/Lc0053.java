package leetcode.lc01000.lc0100;

public class Lc0053 {
    
    public int maxSubArray(int[] nums) {
        //int res [][] = new int[nums.length][nums.length];
        int max = nums[0];
        int pre = nums[0];
        for (int i = 1; i < nums.length; i++) {
            pre = Math.max(pre + nums[i],nums[i]);
            max = Math.max(pre,max);
        }
        return max;
    }
}
