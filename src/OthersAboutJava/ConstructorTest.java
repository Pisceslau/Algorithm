package OthersAboutJava;

import java.lang.reflect.Constructor;

/**
 * Created by Lunar on 2016/3/12.
 * 本类测试反射获得的类的构造器对象
 * 并通过类构造器对象生成该类的实例
 */
public class ConstructorTest {
    public static void main(String[] args) {
        try {
            Class cla = Class.forName("OthersAboutJava.Tests");
            //设置CLass对象数组用于指定构造方法类型
            Class[] cl = new Class[]{int.class, int.class};//构造方法的类型也是类，所以类数组
            //获得Constructor构造器对象并指定构造方法类型
            Constructor con = cla.getConstructor(cl);
            //给传入参数赋初值
            Object[] x = {new Integer(33), new Integer(67)};
            //得到实例，调用构造器了产生了对象（实例）
            Object obj = con.newInstance(x);//根据传入的值创建新对象
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Tests {
    public Tests(int x, int y) {
        System.out.println(x + " " + y);

    }
}