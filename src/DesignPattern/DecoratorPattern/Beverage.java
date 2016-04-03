package DesignPattern.DecoratorPattern;

/**
 * Created by Lunar on 2016/4/3.
 * Head First 设计模式：装饰者模式Decorator
 * 抽象类Beverage
 */
public abstract class Beverage {
    String description = "Unknown Beverage";

    public String getDescription() {
        return description;
    }

    public abstract double cost();
    //
}
