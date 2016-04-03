package DesignPattern.FacadePattern;

/**
 * Created by Lunar on 2016/4/3.
 * Head First设计模式：外观模式
 * 外观不只是简化了接口，也将客户从组件的子系统中解耦
 * 外观的意图是简化接口！
 * 此类为Head First设计模式中外观模式的家庭影院Demo
 */
public class HomeTheaterFacade {
    Amplifier amp;
    DvdPlayer dvd;
    Tuner tuner;
    CdPlayer cd;
    Projector projector;
    TheaterLights lights;
    Screen screen;
    PopcornPopper popper;

    public HomeTheaterFacade(Amplifier amp,
                             Tuner tuner,
                             DvdPlayer dvd,
                             CdPlayer cd,
                             Projector projector,
                             Screen screen,
                             TheaterLights lights,
                             PopcornPopper popper) {
        this.amp = amp;
        this.dvd = dvd;
        this.tuner = tuner;
        this.cd = cd;
        this.projector = projector;
        this.lights = lights;
        this.screen = screen;
        this.popper = popper;
    }

    //其他的方法
    public void watchMovie(String movie) {
        System.out.println("Get ready to watch a movie.");
        popper.on();
        lights.dim(10);
        screen.down();
        projector.on();
        projector.wideScreenMode();
        popper.on();
        amp.setSurroundSound();
        amp.setVolume(5);
        dvd.on();
        dvd.play();
    }

    public void endMovie() {
        System.out.println("Shutting movie theater down...");
        popper.off();
        lights.on();
        screen.up();
        projector.off();
        amp.off();
        dvd.stop();
        dvd.eject();
        dvd.off();
    }
}
