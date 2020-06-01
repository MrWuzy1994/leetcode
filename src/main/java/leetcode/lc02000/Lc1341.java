package leetcode.lc02000;

import java.util.ArrayList;
import java.util.List;

public class Lc1341 {

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        //防止数组扩容消耗时间
        List<Boolean> results = new ArrayList<>( candies.length + (candies.length >> 1));
        //如果数组为空，返回空数组
        if(candies.length < 1){
            return results;
        }
        //找到最大值
        int max = candies[0];
        for (int i = 1; i < candies.length; i++) {
            max = Math.max(candies[i],max);
        }
        //判断当前元素加上额外值以后是否大于等于最大值
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] + extraCandies >= max){
                results.add(true);
            }else{
                results.add(false);
            }
        }
        return results;
    }
}
