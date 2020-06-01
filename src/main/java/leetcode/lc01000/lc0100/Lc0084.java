
package leetcode.lc01000.lc0100;

public class Lc0084 {

    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0)
            return 0;

        int maxValue = 0;
        for (int i = 0; i < heights.length; i++) {
            int minHeight = heights[i];

            for (int j = i; j < heights.length; j++) {
                int currentValue=0;
                if (i == j){
                    currentValue = heights[i];
                }else {
                    minHeight = Math.min(minHeight,heights[j]);
                    int tempHeight = minHeight * (j - i + 1);
                    currentValue = Math.max(tempHeight,heights[j]);
                }
                maxValue = Math.max(maxValue,currentValue);
            }
        }
        return maxValue;
    }

    public static void main(String[] args) {
        Lc0084 lc0084 = new Lc0084();
        System.out.println(lc0084.largestRectangleArea(new int[]{1, 5, 6, 1, 1, 1, 1, 1, 1}));
    }
}
