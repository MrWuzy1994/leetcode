package leetcode.lc01000.lc0100;

/**
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 *
 */
public class Lc0011 {

    /**
     * 暴力解法
     * @param height
     * @return
     */
    public int maxAreaBak(int[] height) {
        if (height.length < 1)
            return 0;
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                max = Math.max(max,(j - i) * Math.min(height[i],height[j]));
            }
        }
        return max;
    }


    /**
     * 双指针法
     *      同等情况下，越宽，对应的体积绝大
     *      区域受限于较短的边
     * @param height
     * @return
     */
    public int maxArea(int[] height) {

        //左侧指针
        int left = 0;
        //右侧指针
        int right = height.length - 1;
        int max = 0;
        while (left < right){
            max = Math.max ((right - left ) * Math.min(height[left],height[right]),max);
            if (height[left] > height[right]){
                right --;
            }else {
                left ++;
            }
        }
        return max;
    }

}
