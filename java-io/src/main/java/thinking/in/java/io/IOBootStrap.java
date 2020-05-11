package thinking.in.java.io;

import thinking.in.java.io.IOThread;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.concurrent.*;

/**
 * no
 *
 * @author yitian
 * @date 2020/5/8 13:56
 */
public class IOBootStrap {

    public static void main(String[] args) throws IOException {
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        ThreadPoolExecutor threadPoolExecutor =
            new ThreadPoolExecutor(10,10,1000, TimeUnit.SECONDS,new LinkedBlockingQueue<>(10));

        ServerSocket serverSocket = new ServerSocket();
        serverSocket.bind(new InetSocketAddress(8080),8080);
        while (!Thread.currentThread().isInterrupted()){
            Socket socket =new Socket();
            threadPoolExecutor.submit(new IOThread(socket));
        }

    }

}
