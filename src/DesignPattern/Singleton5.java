package DesignPattern;

/**
 * Created by Lunar on 2016/4/3.
 * 双重检验加锁 在getInstance()中使用同步
 * 使用双重检验加锁首先检查实例是否已经创建了，如果尚未，才进行同步，只有第一次会同步。
 * 只可以在1.4之后的Java程序中
 * 之前的JVM会对volatile关键字实现导致双重锁的失败。
 * volatile关键字确保instance被实例化，其他线程可见，可见性。
 */
public class Singleton5 {
    private volatile static Singleton5 instance;

    private Singleton5() {
    }

    public static Singleton5 getInstance() {
        if (instance == null) {
            synchronized (Singleton5.class) {
                if (instance == null)
                    instance = new Singleton5();
            }
        }
        return instance;
    }
}
