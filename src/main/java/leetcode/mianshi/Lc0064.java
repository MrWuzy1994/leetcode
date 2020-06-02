package leetcode.mianshi;

public class Lc0064 {

    /**
     * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
     */
    public int sumNumsbBak(int n) {
        return  n + (n * (n - 1)) / 2;
    }

    /**
     * 递归方法，不允许使用if等判断语句等
     * 换一种思路，递归方法的结束条件
     *      可以使用  && 语句 ，如果前半部分条件为false，则后半部分则不会执行
     *      可以使用  || 语句 ，如果前半部分条件为true，则后半部分则不会执行
     *   利用上述条件，则可以判断递归结束条件
     *
     * @param n
     * @return
     */
    public int sumNums(int n) {
        boolean flag = n > 0 && (n += sumNums(n - 1))> 0;
        return n;
    }
}
