package leetcode.lc01000.lc0100;

public class Lc0008 {
    public int myAtoi(String str) {
        str = str.trim();//去除字符串中的空格
        if (str.length() == 0){//如果没有字符,返回0
            return 0;
        }
        long value = 0L;
        if ( '+' == str.charAt(0) ){//首字符如果是 + 说明是正数,从下一位开始计算数字
             value = zheng(1,str);
        }else if ('-' == str.charAt(0)){//首字符是 -  说明是负数,从下一位字符开始判断
            value = -1 * zheng(1,str);
        }else if (isNumber(str.charAt(0))){//首字符是数字,从当前位置判断
            value = zheng(0 ,str);
        }
        if (value < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        if (value > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        return (int) value;
    }

    //计算字符中的数字
    public long zheng(int index,String str){
        int i = index; // 从下标i开始算起
        long number = 0L;//最后的值,设置为Long 防止int 溢出
        for (; i < str.length(); i++) {
            if (!isNumber(str.charAt(i))){//判断当前如果不是数字,结束判断
                break;
            }else {
                number = number * 10 + Long.parseLong(String.valueOf(str.charAt(i))); //数字 * 10 + 当前字符
                if (number > Integer.MAX_VALUE){//结果大于Integer 最大值,后面的字符不用判断,直接返回
                    break;
                }
            }
        }
        return number;
    }

    //判断是否为数字
    public boolean isNumber(char c){
        if ('0' <= c && '9' >= c){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Lc0008 l = new Lc0008();
        System.out.println(l.myAtoi("91283472332"));
    }
}
