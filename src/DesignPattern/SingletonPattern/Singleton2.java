package DesignPattern.SingletonPattern;

/**
 * Created by Lunar on 2016/3/26.
 * Java单例模式
 */
public class Singleton2 {
    private static Singleton2 instance = null;

    public static synchronized Singleton2 getInstance() {
        if (instance == null) {
            instance = new Singleton2();
        }
        return instance;
    }
}

class Test2 {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        Singleton singleton1 = Singleton.getInstance();
        System.out.println(singleton == singleton1);//输出为true
    }
}