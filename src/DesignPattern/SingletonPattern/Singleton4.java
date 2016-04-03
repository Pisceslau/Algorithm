package DesignPattern.SingletonPattern;

/**
 * Created by Lunar on 2016/4/3.
 * 饿汉式 ，在静态初始化器创建单例，保证了线程安全
 * 因为JVM加载这个类马上就创建此唯一的单件实例JVM保证在任何线程访问instance
 * 之前，一定先创建此实例。
 */
public class Singleton4 {
    private static Singleton4 instance = new Singleton4();

    private Singleton4() {
    }

    public static Singleton4 getInstance() {
        //存在instance，直接返回
        return instance;
    }
}
