package thinking.in.java.reflect;

/**
 * 子类
 *
 * @author yitian
 * @date 2020/5/4 17:16
 */
public class SubClass extends SuperClass{

    private String age;

    protected String high;

    public String sex;

    static {   System.out.println("Loading SubClass"); }

    public SubClass(String sex) {
        this.sex = sex;
        System.out.println("SubClass 初始化");
    }


    public void printSubMsg(){
        System.out.println("Sub Msg - sex : "
            + sex );
    }



    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }
}
