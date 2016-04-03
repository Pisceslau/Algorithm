package DesignPattern.DecoratorPattern;

/**
 * Created by Lunar on 2016/4/3.
 * 装饰者模式的调料类
 */
public abstract class CondimentDecorator extends Beverage {
    //首先必须Condiment Decorator能够取代Beverage所以Condiment Decorator扩展了Beverage
    public abstract String getDescription();
    //所有的调料装饰者都必须实现getDescription方法。
}
