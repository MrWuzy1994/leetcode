package leetcode.lc01000.lc0200;

public class Lc0191 {

    public int hammingWeight(int n) {
        int count = 0;
        while (n > 0){
            if (n%10 == 1){
                count ++;
            }
            n /= 10;
        }
        return count;
    }

    public static void main(String[] args) {
        Lc0191 lc0191 = new Lc0191();
        int i = 00000000000000000000000000001011;
        //lc0191.hammingWeight();
    }
}
