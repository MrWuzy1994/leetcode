package leetcode.lc01000.lc0100;

import java.util.*;

public class Lc0047 {
    Set<String> allSet = new HashSet<>();
    List<List<Integer>> all = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums.length < 2){
            putObj(nums);
            return all;
        }
        allSort(nums,0);
        return all;
    }

    public void allSort(int nums[],int index){
        if (index >= nums.length-1){
            List<Integer> number = new ArrayList<>();
            String temp = "";
            for (int i = 0; i < nums.length; i++) {
                temp += nums[i];
                number.add(nums[i]);
            }
            if (!allSet.contains(temp)){
                allSet.add(temp);
                all.add(number);
            }
            return;
        }
        for (int i = index; i < nums.length; i++) {
            swap(nums,index,i);
            allSort(nums,index+1);
            swap(nums,index,i);
        }
    }

    public void swap(int nums[],int left,int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public void putObj(int nums[]){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        all.add(list);
    }
    public static void main(String[] args) {
        Lc0047 lc0047 = new Lc0047();
        lc0047.permuteUnique(new int[]{1,2,3});
        System.out.println();
    }
}
