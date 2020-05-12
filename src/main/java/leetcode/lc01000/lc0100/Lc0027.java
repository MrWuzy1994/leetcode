package leetcode.lc01000.lc0100;

public class Lc0027 {
    public int removeElement(int[] nums, int val) {

        int length = 0;
        int left = 0;
        int right = nums.length - 1;
        while (left < right){
            while (nums[left] != val && left < right)
                left ++;
            while (nums[right] == val && right > left)
                right--;
            if (left < right){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val){
                length ++;
            }
        }
        return  length;
    }
}


