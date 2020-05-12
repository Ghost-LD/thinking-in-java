package thinking.in.java.nio.buffer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

/**
 * 从buffer读取数据 写入channel
 *
 * @author yitian
 * @date 2020/5/12 14:57
 */
public class ReadBuffer {

    public static String readBuffer(String file){

        //从buffer读取数据 写入channel
        FileChannel fileChannel = null;
        try {
            fileChannel = new RandomAccessFile(file, "rwd").getChannel();
            //移动文件指针至尾部，对文件写入
            fileChannel.position(fileChannel.size());
            ByteBuffer byteBuffer = ByteBuffer.allocate(20);
            byteBuffer.put(("helloyitian12dfw \n").getBytes(StandardCharsets.UTF_8));
            //设置 limit 为 position的值，同时设置position =0
            byteBuffer.flip();
            while (byteBuffer.hasRemaining()) {
                fileChannel.write(byteBuffer);
            }
            fileChannel.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "success";
    }


}
