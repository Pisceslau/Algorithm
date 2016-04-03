package DesignPattern;

/**
 * Created by Lunar on 2016/4/3.
 * 单例模式7：枚举类型
 * 缺点：jdk1.5后
 * 默认枚举实例的创建是线程安全的.(创建枚举类的单例在JVM层面也是能保证线程安全的),
 * 所以不需要担心线程安全的问题，所以理论上枚举类来实现单例模式是最简单的方式。
 */
public enum Singleton7 {
    instance,;

    //使用方法
    public static void main(String[] args) {
        Singleton7 singleton7 = Singleton7.instance;
        singleton7.doSomething();
    }

    public void doSomething() {
    }
}
