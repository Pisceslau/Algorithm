package DesignPattern.DecoratorPattern;

/**
 * Created by Lunar on 2016/4/3.
 */
public class HouseBlend extends Beverage {
    public HouseBlend() {
        description = "House Blend Coffee";
    }

    @Override
    public double cost() {
        return .89;
    }
}
