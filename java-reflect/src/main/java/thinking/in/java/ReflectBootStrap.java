package thinking.in.java;

import org.springframework.web.bind.annotation.RequestMapping;
import thinking.in.java.reflect.OprationClass;

/**
 * 引导类
 *
 * @author yitian
 * @date 2020/5/4 16:40
 */
//@SpringBootApplication
//@RestController
public class ReflectBootStrap {


    @RequestMapping("/")
    public String index() {
        return "Hello World !!!";
    }

    public static void main(String[] args) {
        try {
            Class cl = Class.forName("thinking.in.java.reflect.SubClass");
            OprationClass.getFields(cl);
            OprationClass.getDeclaredFields(cl);
            OprationClass.getMethods(cl);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
