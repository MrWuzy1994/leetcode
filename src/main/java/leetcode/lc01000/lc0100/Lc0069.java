package leetcode.lc01000.lc0100;

public class Lc0069 {

    public int mySqrt(int x) {
        if (x < 2){
            return x;
        }
        double midel =  x / 2;
        while (midel * midel > x){
            midel /= 2;
        }
        return (int)midel;
    }

}
