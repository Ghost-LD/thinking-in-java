package thinking.in.java.cglib;

import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.NoOp;

/**
 * boot strap
 *
 * @author yitian
 * @date 2020/5/22 11:18
 */
public class DemoCglibBootStrap {

    public static void main(String[] args) {
        DemoCglibHandlerProxy proxy = new DemoCglibHandlerProxy();
        DemoCglibAnotherProxy demoCglibAnotherProxy = new DemoCglibAnotherProxy();

        DemoFilter demoFilter = new DemoFilter();

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(DemoCglibHandler.class);

        enhancer.setCallbacks(new Callback[]{proxy,demoCglibAnotherProxy, NoOp.INSTANCE});
//        enhancer.setCallback(proxy);
        enhancer.setCallbackFilter(demoFilter);


        DemoCglibHandler demoCglibHandler = (DemoCglibHandler) enhancer.create();
        demoCglibHandler.parser1();
        demoCglibHandler.parser2();

    }

}
