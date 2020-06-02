package leetcode.lc01000.lc0700;


/**
 * 最初在一个记事本上只有一个字符 'A'。你每次可以对这个记事本进行两种操作：
 *
 * Copy All (复制全部) : 你可以复制这个记事本中的所有字符(部分的复制是不允许的)。
 * Paste (粘贴) : 你可以粘贴你上一次复制的字符。
 * 给定一个数字 n 。你需要使用最少的操作次数，在记事本中打印出恰好 n 个 'A'。输出能够打印出 n 个 'A' 的最少操作次数。
 *
 * 示例 1:
 *
 * 输入: 3
 * 输出: 3
 * 解释:
 * 最初, 我们只有一个字符 'A'。
 * 第 1 步, 我们使用 Copy All 操作。
 * 第 2 步, 我们使用 Paste 操作来获得 'AA'。
 * 第 3 步, 我们使用 Paste 操作来获得 'AAA'。
 *
 */
public class Lc0650 {


    /**
     * 递归法
     *      分解n，从2开始，看能否整除n，到n的开方截止
     *          如果能被整除，递归n对应的另一较大的除数
     *          如果发现n是个质数，则返回n本身
     * @param n
     * @return
     */
    public int minStepsDg(int n) {
        if (n < 2){
            return 0;
        }
        //计算for循环的结束条件，如果除到n的开开方数还不能被整除，说明n是个质数
        int sqrt = (int) Math.floor(Math.sqrt(n));
        //判断n能被那个数整除
        for (int i = 2; i <= sqrt; i++) {
            //能被整除
            if (n % i == 0 ){
                //递归的找到大数对应的操作次数
                int son = minSteps(n / i);
                //返回相加结果
                return son + i - 1;
            }
        }
        //不能被整除，说明n是个质数，只能操作n次
        return n;

    }


    /**
     * 循环解决
     *
     * @param n
     * @return
     */
    public int minSteps(int n) {
        int res = 0;
        for (int i = 2; i <= n; i++) {
            while (n % i == 0) {
                res += i;
                n /= i;
            }
        }
        return res;
    }

}
