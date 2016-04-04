package DesignPattern.ObserverPattern;

/**
 * Created by Lunar on 2016/4/4.
 * 观察者模式：主题
 */
public interface Subject {
    void registerObserver(Observer o);

    void removeObserver(Observer o);//前面二哥方法都需要一个观察者作为变量，该观察者是用来注册或删除

    void notifyObservers();//当主题状态改变时候，主题会把这些状态值当作方法的参数

}

