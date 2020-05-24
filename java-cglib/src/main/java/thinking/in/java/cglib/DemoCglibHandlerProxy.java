package thinking.in.java.cglib;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * cglib proxy
 *
 * @author yitian
 * @date 2020/5/22 11:09
 */
public class DemoCglibHandlerProxy implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("DemoCglibHandlerProxy before invoke");
        methodProxy.invokeSuper(o,objects);
        System.out.println("DemoCglibHandlerProxy after invoke");
        return null;
    }
}
