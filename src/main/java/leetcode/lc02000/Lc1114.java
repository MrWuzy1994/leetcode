package leetcode.lc02000;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Lc1114 {


}


class Foo {


    CountDownLatch c = new CountDownLatch(1);
    CountDownLatch c2 = new CountDownLatch(2);
    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        c.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        c.await();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        c2.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {

        c2.await();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}