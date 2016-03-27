package DesignPattern;

/**
 * Created by Lunar on 2016/3/26.
 * Java单例模式
 */
public class Singleton {
    private Singleton() {

    }

    private static Singleton instance = new Singleton();

    public static Singleton getInstance() {
        return instance;
    }

}

class Test {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        Singleton singleton1 = Singleton.getInstance();
        System.out.println(singleton == singleton1);//输出为true
    }
}
