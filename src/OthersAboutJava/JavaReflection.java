package OthersAboutJava;

import javax.swing.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 本类用于测试反射API，利用用户输入类的全路径，
 * 找到该类所有的成员方法和成员属性
 *    大家可以发现，类的全路径是在程序运行的时候，由用户输入的。所以虚拟机事先并不知道所要加载类的信息，这就是利用反射机制来对用户输入的类全路径来对类自身的一
 *    个自审。从而探知该类所拥有的方法和属性。
 */
public class JavaReflection {
    /**
     * 构造方法
     */
    public JavaReflection() {
        String classInfo = JOptionPane.showInputDialog(null, "输入类全路径");//要求用户输入类的全路径
        try {//forName:返回特定名字的Class对象
            Class cla = Class.forName(classInfo);//根据类的全路径进行类加载，返回该类的Class对象

            Method[] method = cla.getDeclaredMethods();//利用得到的Class对象的自审，返回方法对象集合

            for (Method me : method) {//遍历该类方法的集合
                System.out.println(me.toString());//打印方法信息
            }

            System.out.println("********");

            Field[] field = cla.getDeclaredFields();//利用得到的Class对象的自审，返回属性对象集合
            for (Field me : field) { //遍历该类属性的集合
                System.out.println(me.toString());//打印属性信息
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new JavaReflection();
    }
}
