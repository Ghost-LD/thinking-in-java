package ts;

/**
 * TODO
 *
 * @author yitian
 * @date 2020/6/12 10:36
 */
public class UserInfo {

    private int age;

    private String name;


    public UserInfo() {
        this("xx");
        System.out.println("构造器1调用");
    }

    public UserInfo(int age) {
        this.age = age;
    }

    public UserInfo(String name) {
        this(1,name);
        System.out.println("构造器2调用");
    }


    public UserInfo(int age, String name) {
        this.age = age;
        this.name = name;
        System.out.println("构造器3调用");
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserInfo{" + "age=" + age + ", name='" + name + '\'' + '}';
    }



}
