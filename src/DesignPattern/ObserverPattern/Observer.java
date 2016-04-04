package DesignPattern.ObserverPattern;

/**
 * Created by Lunar on 2016/4/4.
 */
public interface Observer {
    //当气象观测值改变主题会把这些状态值当作参数传给观察者。
    void update(float temp, float humidity, float pressure);
}
