package thinking.in.java.reflect;

/**
 * 父类
 * 模拟通过反射获取超类相关信息
 * @author yitian
 * @date 2020/5/4 17:14
 */
public class SuperClass {

    public String name;

    public String nationality;

    static {   System.out.println("Loading SuperClass"); }

    public void printSupMsg(){
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
}
