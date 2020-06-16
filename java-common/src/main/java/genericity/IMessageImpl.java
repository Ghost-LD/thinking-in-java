package genericity;

/**
 * TODO
 *
 * @author yitian
 * @date 2020/6/15 14:00
 */
public class IMessageImpl implements IMessage {

    @Override
    public String send() {
        System.out.println("send message success");
        return null;
    }
}
