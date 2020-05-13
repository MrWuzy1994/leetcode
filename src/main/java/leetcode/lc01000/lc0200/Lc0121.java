package leetcode.lc01000.lc0200;

public class Lc0121 {

    /**
     *
     * 思路，今天卖出股票，获取的收益为，今天的价格减去今天之前出现的历史最低值
     * 获取当前天之前买入的最低值
     * 当前天的价格减去前面最低值的价格，获取差值，比较之前天减去最小值的差值的大小，如果当前天的差值较大，记录最大值，继续比较下一个
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices.length < 2)
            return 0;
        int min = prices[0];
        int maxValue = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min){
                min = prices[i];
            }else if (prices[i] - min > maxValue){
                maxValue = prices[i] - min;
            }
        }
        return maxValue;
    }
    public int maxProfitBaoli(int[] prices) {
        if (prices == null || prices.length < 2)
            return 0;
        int max = 0;
        for (int i = prices.length - 1; i >= 1 ; i-- ) {
            for (int j = i - 1 ; j >= 1 ; j --) {
                int temp = prices[i] - prices[j];
                if (temp > max)
                    max = temp;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Lc0121 lc0121 = new Lc0121();
        lc0121.maxProfit(new int[]{1,2});

    }
}
