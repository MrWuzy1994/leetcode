package leetcode.lc01000.lc0100;

public class Lc0050 {
    public  double quick(double x, int n) {
        if (n == 0){
            return 1;
        }
        double c = quick(x,n / 2);
        return n % 2 == 0 ? c * c : c * c * x;
    }

    public double myPow(int x,int n){
        if (x == 1 || n == 0)
            return 1;
        return n > 0 ? quick(x,n) : 1 / quick(x,-n);
    }






}

