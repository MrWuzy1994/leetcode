package leetcode.lc01000.lc0200;

import java.util.HashSet;
import java.util.Set;

public class Lc0128 {
    /**
     * 给定一个未排序的整数数组，找出最长连续序列的长度。
     *
     * 要求算法的时间复杂度为 O(n)。
     *
     * 示例:
     *
     * 输入: [100, 4, 200, 1, 3, 2]
     * 输出: 4
     * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
     *
     *
     *  解题思路，构造一个存储元素集合，题目要求是连续数组，当前元素+1以后判断集合中是否存在当前元素的下一个元素，如果存在长度+1
     *      由于题目要求是最长的，如果当前元素有前驱元素，说明当前元素不是最长序列的开头，因此可以跳过当前元素的判断
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        //校验参数的有效性
        if (nums ==  null){
            return 0;
        }
        //存放所有元素的集合
        Set<Integer> set = new HashSet<>(nums.length * 2);
        //构造无重复的集合
        for (Integer n:nums
        ) {
            set.add(n);
        }

        int max = 0;
        //循环判断每个元素的后驱元素是否存在，如果存在，长度+1，直到不存在后驱元素为止
        for (Integer n:nums
        ) {
            //如果当前元素有前驱元素，说明不是最长的，如果当前元素没有前驱，则这个元素在数组的最开始为止
            if (!set.contains(n - 1)){
                //临时长度，自己本身为
                int tempLength = 1;
                //+1后寻找下一个元素
                int temp = n + 1;
                //如果下移个元素存在，长度+1，直到找不到下个元素为止
                while (set.contains(temp)){
                    tempLength ++ ;
                    temp += 1;
                }
                //获取最大值
                max = Math.max(max,tempLength);
            }

        }
        //返回最大值
        return max;
    }
}
