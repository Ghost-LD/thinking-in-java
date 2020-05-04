package thinking.in.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 引导类
 *
 * @author yitian
 * @date 2020/5/4 16:40
 */
@SpringBootApplication
@RestController
public class ReflectBootStrap {


    @RequestMapping("/")
    public String index() {
        return "Hello World !!!";
    }

    public static void main(String[] args) {
        SpringApplication.run(ReflectBootStrap.class,args);
    }
}
