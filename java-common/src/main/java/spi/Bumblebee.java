package spi;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 *
 * @author yitian
 * @date 2020/6/26 17:22
 */
public class Bumblebee implements Robot {

    private static Map<Byte, Integer> ID_SERIALIZATION_MAP = new HashMap<Byte, Integer>();

    static {
        System.out.println("1111111111");
    }

    public static int getSerializationById(Byte id) {
        return ID_SERIALIZATION_MAP.get(id);
    }

    @Override
    public void sayHello() {
        System.out.println("Hello, I am Bumblebee.");
    }


}
