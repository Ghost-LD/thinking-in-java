package thinking.in.java.reflect;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * TODO
 *
 * @author yitian
 * @date 2020/6/28 16:10
 */
public class UnsafeTest {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        System.out.println(ClassLoader.getSystemClassLoader());
        Class<Unsafe> t = Unsafe.class;
        Field theUnsafe = (Field) t.getDeclaredField("theUnsafe");
        theUnsafe.setAccessible(true);
        Unsafe unsafe = (Unsafe) theUnsafe.get(t);
        System.out.println(unsafe);
    }

}
