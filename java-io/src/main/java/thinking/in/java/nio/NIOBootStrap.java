package thinking.in.java.nio;

import thinking.in.java.nio.buffer.ReadBuffer;
import thinking.in.java.nio.buffer.WriteBuffer;

/**
 * nio
 *
 * @author yitian
 * @date 2020/5/11 14:17
 */
public class NIOBootStrap {

    public static void main(String[] args) {
        String file = "/logs/hqbs-platform/zebra_error.log";
        //1.从buffer读取数据 写入channel
        System.out.println(ReadBuffer.readBuffer(file));
//        WriteBuffer.writeBuffer(file);

    }

}
