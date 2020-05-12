package leetcode.lc02000;

import java.util.Scanner;
import java.util.function.IntConsumer;

public class Lc1116 {


}
class ZeroEvenOdd {
    private volatile int n;
    private volatile Object o = new Object();
    private volatile int current = 1;
    private volatile Boolean b = true;


    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        synchronized (o) {
            while (current <= n) {
                while (!b) {
                    o.wait();
                }
                if (current != n){
                    printNumber.accept(0);

                }
                b = false;
                o.notifyAll();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        synchronized (o) {
            while (current <= n ) {
                while (b && current % 2 != 0) {
                    o.wait();
                }
                printNumber.accept(current);
                current ++;
                b = true;
                o.notifyAll();
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        synchronized(o) {
            while (current <= n ) {
                while (b && current % 2 == 0) {
                    o.wait();
                }
                printNumber.accept(current);
                current ++;
                b = true;
                o.notifyAll();
            }
        }
    }
}