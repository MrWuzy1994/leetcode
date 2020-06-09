package leetcode.mianshi;

import java.util.HashMap;
import java.util.Map;

/**
 *
 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。

 示例 1:
 输入: 12258
 输出: 5
 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 */
public class Lc0046 {

    Map<String,String> map = new HashMap<>();

    public void init(){
        for (int i = 0; i < 26; i++) {
            map.put(String.valueOf(i),String.valueOf((char)(i + 'a')));
        }
    }

    /**
     * 动态规划
     *  dp[i] = dp[i-1] + (0 <= S[i-1] + S[i] <=25) ? dp[i-2] : 0;
     *
     * @param num
     * @return
     */
    public int translateNum(int num) {
        String src = String.valueOf(num);
        //dp[i-1]  dp[i -2] dp[i]
        int p = 0, q = 0, r = 1;
        for (int i = 0; i < src.length(); ++i) {
            //记录dp[i-2] = dp[i-1]
            p = q;
            //dp[i-1] = dp[i]
            q = r;
            //dp[i] = dp[i-1]
            r = 0;
            r += q;
            if (i == 0) {
                continue;
            }
            //(0 <= S[i-1] + S[i] <=25)   d[i] += dp[i-2]
            String pre = src.substring(i - 1, i + 1);
            if (pre.compareTo("25") <= 0 && pre.compareTo("10") >= 0) {
                r += p;
            }
        }
        return r;
    }

    //回溯算法
    public int translateNumHs(int num) {
        init();
        return dg(String.valueOf(num),0);
    }

    public int dg(String str,int index){
        //递归结束条件,下标到最后一位，返回数值1
        if (index >= str.length()){
            return 1;
        }
        //固定当前位置，递归判断子位置
        int firstNum = dg(str,index + 1);
        //固定当前两个个位置，递归判断子串位置
        int lastNum = 0;
        if (index < str.length() - 1 && map.containsKey("" + str.charAt(index) + str.charAt(index + 1))){
            lastNum = dg(str,index + 2);
        }
        return firstNum+lastNum;
    }


}
