package leetcode.lc01000.lc0100;

import java.util.ArrayList;
import java.util.List;

public class Lc0022 {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList();
        backtrack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    public void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max){
        //递归结束条件，长度达标
        if (cur.length() == max * 2) {
            ans.add(cur.toString());
            return;
        }

        //如果左括号没有用完，可以继续拼接左括号
        if (open < max) {
            //拼接做括号
            cur.append('(');
            //左括号加1，递归调用
            backtrack(ans, cur, open+1, close, max);
            //删除拼接的左括号
            cur.deleteCharAt(cur.length() - 1);
        }
        //如果有右括号小于左括号的个数，需要拼接右括号
        if (close < open) {
            //拼接右括号
            cur.append(')');
            //右括号个数+1，递归调用
            backtrack(ans, cur, open, close+1, max);
            //删除拼接的右括号
            cur.deleteCharAt(cur.length() - 1);
        }
    }

}
