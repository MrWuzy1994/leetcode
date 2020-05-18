package leetcode.lc01000.lc0200;

public class Lc0152 {

    public int maxProduct(int[] nums) {
        if (nums.length < 0){
            return 0;
        }
        //计算的最大值
        //最小值
        int dmin = nums[0];
        //最大值
        int dmax = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int temp = dmax;
            dmax = Math.max(dmax * nums[i],Math.max(dmin * nums[i],nums[i]));
            dmin = Math.min(temp * nums[i],Math.min(dmin * nums[i],nums[i]));
            max = Math.max(max,dmax);
        }
        return max;
    }


}
