package leetcode.lc01000.lc0200;

public class Lc0198 {

    public int rob(int[] nums) {
        if (nums.length <= 3){
            return jo(nums);
        }
        int one = nums[0],two = nums[1],three = nums[0] +nums[2];
        for (int i = 3; i < nums.length; i++) {
            int temp1 = one + nums[i];
            int temp2 = two + nums[i];
            int temp3 = Math.max(temp1,Math.max(temp2,three));

            one = two;
            two = three;
            three = temp3;
        }
        return Math.max(one,Math.max(two,three));
    }

    public int jo(int[] nums){
        int  o = 0;
        int  j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0){
                o += nums[i];
            }else{
                j += nums[i];
            }
        }
        return Math.max(j,o);
    }

    public static void main(String[] args) {
        Lc0198 lc0198 = new Lc0198();
        lc0198.rob(new int []{1,2,3,1});
    }
}
