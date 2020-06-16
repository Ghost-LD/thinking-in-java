package concurrent;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * TODO
 *
 * @author yitian
 * @date 2020/6/12 15:22
 */
public class Foo {

    //方式一
    private AtomicInteger firstInteger = new AtomicInteger(0);
    private AtomicInteger secondInteger = new AtomicInteger(0);
    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        firstInteger.incrementAndGet();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        // printSecond.run() outputs "second". Do not change or remove this line.
        while (firstInteger.get() != 1){
            //wait
        }
        printSecond.run();
        secondInteger.incrementAndGet();
    }
    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        while (secondInteger.get() != 1){
            //wait
        }
        printThird.run();
    }

    //f方式二

    private boolean firstFlag = false;
    private boolean secondFlag = false;
    private Object lock = new Object();

    public void first2(Runnable printFirst) throws InterruptedException {

        synchronized (lock){
            printFirst.run();
            firstFlag = true;
            lock.notifyAll();
        }
    }

    public void second2(Runnable printSecond) throws InterruptedException {
        synchronized (lock){
            while (!firstFlag){
                lock.wait();
            }
            printSecond.run();
            secondFlag = true;
            lock.notifyAll();
        }
    }
    public void third2(Runnable printThird) throws InterruptedException {
        synchronized (lock){
            while(!secondFlag){
                lock.wait();
            }
            printThird.run();
            lock.notifyAll();
        }
    }







    static class MyRunable implements Runnable {

        String name;

        public MyRunable(String name) {
            this.name = name;
        }

        /**
         * When an object implementing interface <code>Runnable</code> is used
         * to create a thread, starting the thread causes the object's
         * <code>run</code> method to be called in that separately executing
         * thread.
         * <p>
         * The general contract of the method <code>run</code> is that it may
         * take any action whatsoever.
         *
         * @see Thread#run()
         */
        @Override
        public void run() {
            System.out.println("foo:"+name);
        }
    }

}
