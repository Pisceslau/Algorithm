package DesignPattern.SingletonPattern;

/**
 * Created by Lunar on 2016/4/3.
 * 内部类方式
 * 延迟加载，减少内存开销
 * 因为在JVM进行类加载的时候他会保证数据是同步的，我们可以这样实现：
 * <p>
 * 采用内部类，在这个内部类里面去创建对象实例。这样的话，只要应用中不使用内部类 JVM
 * 就不会去加载这个单例类，也就不会创建单例对象，从而实现懒汉式的延迟加载和线程安全。
 */
public class Singleton6 {
    private Singleton6() {
    }

    public static Singleton6 getInstance() {
        return SingletonHolder.instance;
    }

    public void doSomething() {
        //do something;
    }

    //在加载内部时候才会创建单例
    private static class SingletonHolder {
        private static Singleton6 instance = new Singleton6();
    }
}
