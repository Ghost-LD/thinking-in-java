package thinking.in.java.io;


import java.net.Socket;

/**
 * TODO
 *
 * @author yitian
 * @date 2020/5/8 13:57
 */
public class IOThread extends Thread {

    private Socket socket;


    public IOThread(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        super.run();
        while (!Thread.currentThread().isInterrupted() && !socket.isClosed()){
            try {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName()+"---:"+socket.getPort());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
