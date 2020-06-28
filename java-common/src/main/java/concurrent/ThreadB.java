package concurrent;

/**
 * TODO
 *
 * @author yitian
 * @date 2020/6/16 15:58
 */
public class ThreadB implements Runnable {

    private String name;

    public ThreadB(String name) {
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
