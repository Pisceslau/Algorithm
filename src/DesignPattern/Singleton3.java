package DesignPattern;

/**
 * Created by Lunar on 2016/4/3.
 * Head First设计模式：单例模式的经典实现
 * 延迟实例化。没有公有的构造器
 * 单例模式确保一个类只有一个实例，并提供一个全局访问点。
 * 缺点：不能处理多线程。
 */
public class Singleton3 {
    private static Singleton3 instance;

    private Singleton3() {
    }

    //加上synchronized处理多线程情况
    /*只有第一次调用此方法才真正需要同步，一旦设置好，就不在需要同步这个方法了，同步每一次都是一个累赘（性能问题）*/
    public static synchronized Singleton3 getInstance() {
        //instance 拥有一个实例，因为是静态变量 ，公有
        if (instance == null)
            instance = new Singleton3();
        return instance;
    }
}
