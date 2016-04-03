package DesignPattern.FacadePattern;

/**
 * Created by Lunar on 2016/4/3.
 * HeadFirst外观模式驱动测试类。
 */
public class HomeTheaterTestDrive {
    public static void main(String[] args) {
        Amplifier amp = new Amplifier();
        Tuner tuner = new Tuner();
        DvdPlayer dvd = new DvdPlayer();
        CdPlayer cd = new CdPlayer();
        Projector projector = new Projector();
        Screen screen = new Screen();
        TheaterLights lights = new TheaterLights();
        PopcornPopper popper = new PopcornPopper();
        HomeTheaterFacade homeTheater = new HomeTheaterFacade(amp, tuner, dvd, cd, projector, screen, lights, popper);
        homeTheater.watchMovie("Raiders of the Lost Ark");
        homeTheater.endMovie();
    }
}
