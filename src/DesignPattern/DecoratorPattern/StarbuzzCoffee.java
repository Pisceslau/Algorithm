package DesignPattern.DecoratorPattern;

/**
 * Created by Lunar on 2016/4/3.
 * 今日快捷键：Ctrl + H 类层次视图
 */
public class StarbuzzCoffee {
    public static void main(String[] args) {
        Beverage beverage = new Espresso();
        System.out.println(beverage.getDescription() + "$" + beverage.cost());
        Beverage beverage2 = new HouseBlend();
        beverage2 = new Soy(beverage2);
        beverage2 = new Mocha(beverage2);
        beverage2 = new Whip(beverage2);//每行的beverage2 都是上行修饰够后的
        System.out.println(beverage2.getDescription() + "$" + beverage2.cost());
    }
}
