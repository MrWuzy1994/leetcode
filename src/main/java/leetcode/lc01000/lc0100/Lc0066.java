package leetcode.lc01000.lc0100;

public class Lc0066 {
    public int[] plusOne(int[] digits) {
        //+1
        int mark = 1;
        //从末尾遍历,末尾数如果有进位,则判断下一位,如果没有进位,直接返回数组
        for (int i = digits.length-1; i >= 0; i--) {
            //当前为+1
            int temp = digits[i]  + mark;
            //+1 等于10  判断上一位
            if ( temp >= 10){
                digits[i] = 0;
            }else{//如果没有进位,后面的数字不用判断,直接返回数组
                digits[i] = temp;
                return digits;
            }
        }
        //判断到数组首位元素依旧没有跳出返回数据,说明数组是以   多个9组成的元素,新建一个数组,首位置1,其余位置均为默认值0
        int [] newArray = new int[digits.length+1];
        newArray[0] = 1;
        return newArray;
    }
}
