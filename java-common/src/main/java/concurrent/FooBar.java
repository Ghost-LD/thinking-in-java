package concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * TODO
 *
 * @author yitian
 * @date 2020/6/16 15:58
 */
public class FooBar {


    public static ExecutorService executorService = new ThreadPoolExecutor(2,
        3,60, TimeUnit.SECONDS,new LinkedBlockingQueue<>(10));


    private volatile boolean flag = true;

    private int n;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable runnable) {

        for (int i=0;i<n;i++){
            while (!flag){
            }
            runnable.run();
            flag = false;
        }
    }

    public void bar(Runnable runnable){
        for (int i=0;i<n;i++){
            while (flag){
            }
            runnable.run();
            flag = true;
        }
    }

    public static void main(String[] args) {
        Runnable a = new ThreadA("A");
        Runnable b = new ThreadA("B");

        FooBar fooBar = new FooBar(4);
        executorService.execute(()->{
            fooBar.foo(a);
        });
        executorService.execute(()->{
            fooBar.bar(b);
        });
        executorService.shutdown();
    }


    static class ThreadA implements Runnable{

        private String name;

        public ThreadA(String name) {
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
            System.out.print(name);
        }
    }
}
