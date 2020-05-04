package thinking.in.java.reflect;

import java.lang.reflect.Field;

/**
 * 反射操作类
 *
 * @author yitian
 * @date 2020/5/4 17:46
 */
public class OprationClass {

    /**
     * 获取所有public 权限的变量 包括子类和父类继承的
     * @param cl
     */
    public static void getFields(Class cl){
        printMsg("getFields");
        Field[] fields = cl.getFields();
        for (Field field : fields) {
            System.out.println((field.getType().getName()+" "+field.getName()));
        }
    }

    /**
     * 获取本类所有声明的变量
     * @param cl
     */
    public static void getDeclaredFields(Class cl){
        printMsg("getFields");
        Field[] fields = cl.getDeclaredFields();
        for (Field field : fields) {
            System.out.println((field.getType().getName()+" "+field.getName()));
        }
    }


    public static void printMsg(String msg){
        System.out.println("----------"+msg+"-----------");
    }




}
