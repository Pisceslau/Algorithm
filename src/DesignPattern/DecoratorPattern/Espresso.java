package DesignPattern.DecoratorPattern;

/**
 * Created by Lunar on 2016/4/3.
 */
public class Espresso extends Beverage {
    public Espresso() {
        description = "Espresso";
    }

    @Override
    public double cost() {
        return 1.99;
    }
}
