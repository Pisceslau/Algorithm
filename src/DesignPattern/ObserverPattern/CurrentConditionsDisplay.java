package DesignPattern.ObserverPattern;

/**
 * Created by Lunar on 2016/4/4.
 */
public class CurrentConditionsDisplay implements Observer, DisplayElement {
    private float temperature;
    private float humidity;
    private Subject weatherData;

    //需要WeatherData注册
    public CurrentConditionsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }


    @Override
    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        display();//更新则展示
    }

    public void display() {
        System.out.println("Current conditions: " + temperature + "F degrees and " + humidity + "%humidity");
    }

}
