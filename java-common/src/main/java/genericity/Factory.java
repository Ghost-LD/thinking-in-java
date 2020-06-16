package genericity;

/**
 * 工厂类
 *
 * @author yitian
 * @date 2020/6/15 13:58
 */
public class Factory {

    public static <T> T instance(Class<T> tClass) throws IllegalAccessException, InstantiationException {
        return tClass.newInstance();
    }
}
