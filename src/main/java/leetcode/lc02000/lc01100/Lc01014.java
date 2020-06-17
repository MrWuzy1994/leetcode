package leetcode.lc02000.lc01100;

/**
 * 给定正整数数组 A，A[i] 表示第 i 个观光景点的评分，并且两个景点 i 和 j 之间的距离为 j - i。
 *
 * 一对景点（i < j）组成的观光组合的得分为（A[i] + A[j] + i - j）：景点的评分之和减去它们两者之间的距离。
 *
 * 返回一对观光景点能取得的最高分。
 *
 *  
 *
 * 示例：
 *
 * 输入：[8,1,5,2,6]
 * 输出：11
 * 解释：i = 0, j = 2, A[i] + A[j] + i - j = 8 + 5 + 0 - 2 = 11
 *  
 *
 * 提示：
 *
 * 2 <= A.length <= 50000
 * 1 <= A[i] <= 1000
 *
 */
public class Lc01014 {


    /**
     * 动态规划
     *  题目中的公式 a[i] + a[j] + i - j
     *  确定j的位置，与j评分和最高的 a[i] + i 最高的一个
     *      记录当前最该的 a[i] + i
     *      记录最高的评分
     *
     * @param A
     * @return
     */
        public int maxScoreSightseeingPair(int[] A) {
            //记录最高的a[i] +i
            int maxI = A[0] + 0;
            //记录最高的评分和
            int maxValue = Integer.MIN_VALUE;
            for (int i = 1; i < A.length; i++) {
                maxValue = Math.max(maxValue , A[i] - i + maxI);
                maxI = Math.max(maxI,A[i] + i);
            }
            //返回最大值
            return maxValue;
        }

    /**
     * 暴力破解
     * @param A
     * @return
     */
    public int maxScoreSightseeingPairBl(int[] A) {
        int max = 0;
        for (int i = 0; i < A.length - 1; i++) {
            for (int j = i + 1; j < A.length; j++) {
                int temp = A[i] + A[j] + i - j;
                max = Math.max(temp,max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Lc01014 lc01014 = new Lc01014();
        lc01014.maxScoreSightseeingPair(new int[]{8,1,5,2,6});
    }

}
