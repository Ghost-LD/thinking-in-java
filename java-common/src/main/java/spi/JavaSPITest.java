package spi;

import org.junit.Test;

import java.util.ServiceLoader;

/**
 * SPI
 *
 * @author yitian
 * @date 2020/6/26 17:24
 */
public class JavaSPITest {

    @Test
    public void sayHello() throws Exception {
//        ServiceLoader<Robot> serviceLoader = ServiceLoader.load(Robot.class);
//        System.out.println("Java SPI");
//        serviceLoader.forEach(Robot::sayHello);

        System.out.println("Java SPI");
        Bumblebee.getSerializationById((byte)1);
    }

}
