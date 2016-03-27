package OthersAboutJava;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Lunar on 2016/3/27.
 * 《Java编程思想》P654 并发 模拟倒计时
 */
public class LiftOff implements Runnable {
    protected int countDown = 10;
    private static int taskCount = 0;
    private final int id = taskCount++;

    public LiftOff() {

    }

    public LiftOff(int countDown) {
        this.countDown = countDown;
    }

    public String status() {
        return "#" + id + "(" + (countDown > 0 ? countDown : "LiftOff!") + ").";
    }

    @Override
    public void run() {
        while (countDown-- > 0) {
            System.out.print(status());
            Thread.yield();
        }
    }

    public static void main(String[] args) {
        /*LiftOff launch = new LiftOff();
         //launch.run();
        Thread thread = new Thread(launch);
        thread.start();*/
        //Executor中的CacheThreadPool:开一个任务就增加一个线程,ExecutorService：据有关生命周期的Executor
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exec.execute(new LiftOff());
        }
        exec.shutdown();

        //Executor中的FixedThreadPool:预先分配一定数量的线程：线程数量限制了
        ExecutorService exec1 = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            exec1.execute(new LiftOff());

        }
        exec1.shutdown();

        //Executor中的SingleThreadExecutor:只有一个线程所以是序列化顺序执行
        ExecutorService exec2 = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            exec2.execute(new LiftOff());
        }
        exec2.shutdown();
    }
}
