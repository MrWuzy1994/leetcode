package leetcode.lc02000;

import java.util.Scanner;

public class Lc1115 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        FooBar fooBar = new FooBar(n);

    }
}

class FooBar {
    private int n;
    private Object o = new Object();
    //true 表示该打印 foo ;false表示该打印 bar
    private volatile boolean f = true;
    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        synchronized (o){
            for (int i = 0; i < n; i++) {
                    while (!f){ //如果为false,表示该打印bar,释放资源
                        o.wait();
                    }
                    printFoo.run();
                    f = false;
                    o.notify();
            }
            // printFoo.run() outputs "foo". Do not change or remove this line.
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        synchronized (o){
            for (int i = 0; i < n; i++) {
                    while (f){//如果为true,表示该打印foo,释放资源
                        o.wait();
                    }
                    printBar.run();
                    f = true;
                    o.notify();
            }
            // printBar.run() outputs "bar". Do not change or remove this line
        }
    }
}