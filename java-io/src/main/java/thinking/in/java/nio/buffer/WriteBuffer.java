package thinking.in.java.nio.buffer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * TODO
 *
 * @author yitian
 * @date 2020/5/12 15:10
 */
public class WriteBuffer {

    public static String writeBuffer(String file) {
        try {
            FileChannel fileChannel = new RandomAccessFile(file, "rw").getChannel();
            fileChannel.position(0);
            CharBuffer charBuffer = CharBuffer.allocate(10);
            CharsetDecoder decoder = StandardCharsets.UTF_8.newDecoder();

            ByteBuffer byteBuffer = ByteBuffer.allocate(10000);
//            fileChannel.read(byteBuffer);
            int i = 0;
            while (fileChannel.read(byteBuffer) != -1 || byteBuffer.position() > 0) {
                byteBuffer.flip();
                // 使用UTF-8解码器解码
                charBuffer.clear();
                decoder.decode(byteBuffer, charBuffer, false);
                System.out.print(charBuffer.flip().toString());
                //数据可能有剩余
                byteBuffer.compact();
                i++;
            }
            fileChannel.close();
            System.out.println("I:"+i);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "success";
    }

}
