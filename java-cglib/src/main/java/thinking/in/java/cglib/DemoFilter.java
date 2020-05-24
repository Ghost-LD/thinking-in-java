package thinking.in.java.cglib;

import org.springframework.cglib.proxy.CallbackFilter;

import java.lang.reflect.Method;

/**
 * TODO
 *
 * @author yitian
 * @date 2020/5/22 11:29
 */
public class DemoFilter implements CallbackFilter {

    @Override
    public int accept(Method method) {
        if("parser1".equals(method.getName())){
            return 0;
        }
        return 2;
    }
}
