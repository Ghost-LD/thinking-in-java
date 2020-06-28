package thinking.in.java.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 反射操作类
 *
 * @author yitian
 * @date 2020/5/4 17:46
 */
public final class OprationClass {


    public static void d(){
        System.out.println("111111");
    }

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


    /**
     * 获取所有public 权限的方法 包括子类和父类继承的
     * @param cl
     */
    public static void getMethods(Class cl){
        printMsg("getMethods");
        Method[] methods = cl.getMethods();
        for(Method method : methods){
            printMsgs("方法返回类型：",method.getReturnType()+""," 方法名：", method.getName());
        }
    }


    public static void printMsg(String msg){
        System.out.println("----------"+msg+"-----------");
    }

    public static void printMsgs(String... msg){
        for (String s : msg){
            System.out.print(s);
        }
        System.out.println();

    }



}
