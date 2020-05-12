package leetcode.lc01000.lc0100;

public class Lc0029 {
    public int divide(int dividend, int divisor) {
        int fuhao = 1;

        int shang = 0;
        if (divisor < dividend){
            shang ++;
        }
        while (divisor < dividend){
            divisor += divisor;
            shang ++;
        }
        return shang;
    }

}
