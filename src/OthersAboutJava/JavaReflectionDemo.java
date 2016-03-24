package OthersAboutJava;

/**
 * Created by Lunar on 2016/3/12.
 * Java反射机制的类加载静态方法
 */
public class JavaReflectionDemo {
    public static void main(String[] args) {
        TestOne one = null;
        try {
            Class cla = Class.forName("OthersAboutJava.TestOne");
            System.out.println("******");
            one = (TestOne) cla.newInstance();//产生这个Class对象的新的实例对象
        } catch (Exception e) {
            e.printStackTrace();
        }
        TestOne two = new TestOne();
        System.out.println(one.getClass() == two.getClass());//如果对象类型相同会有相同的Class对象

    }


}

class TestOne {
    static {
        System.out.println("静态代码块运行");
    }

    TestOne() {
        System.out.println("构造方法");
    }
}
