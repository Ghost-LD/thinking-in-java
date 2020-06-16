package genericity;

/**
 * 泛型
 *
 * @author yitian
 * @date 2020/6/15 11:43
 */
public class Message<T> {

    private T msg;

    public T getMsg() {
        return msg;
    }

    public void setMsg(T msg) {
        this.msg = msg;
    }
}
