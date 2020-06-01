package leetcode.bisai;

public class Lc5424 {

    public int maxProduct(int[] nums) {


        int one = Math.max(nums[0],nums[1]);
        int two = Math.min(nums[0],nums[1]);;
        for (int i = 2; i <nums.length ; i++) {
            if (nums[i] >= one){
                two = one;
                one = nums[i];
            }else if (nums[i] > two){
                two = nums[i];
            }
        }
        return (two - 1) * (one - 1);
    }
}
