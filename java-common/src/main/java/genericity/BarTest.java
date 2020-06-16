package genericity;

/**
 * TODO
 *
 * @author yitian
 * @date 2020/6/15 11:44
 */
public class BarTest {

    public static void main(String[] args) {
        Message<String> stringMessage = new Message<>();
        stringMessage.setMsg("xxxxx");
        Message<?> s = fun(stringMessage);
        System.out.println(s.getMsg());

        try {

            IMessage iMessage = Factory.instance(IMessageImpl.class);
            iMessage.send();

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }


    }

    public static Message<?> fun(Message<?> msg){

        System.out.println(msg.getMsg());
        return msg;
    }

}
