package thinking.in.java.cglib;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * TODO
 *
 * @author yitian
 * @date 2020/5/22 11:28
 */
public class DemoCglibAnotherProxy implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("DemoCglibAnotherProxy before invoke");
        methodProxy.invokeSuper(o,objects);
        System.out.println("DemoCglibAnotherProxy after invoke");
        return null;
    }
}
