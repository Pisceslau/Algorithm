package OthersAboutJava;

/**
 * Created by Lunar on 2016/3/12.
 * Java interrupt方法
 */
public class JavaInterrupt implements Runnable {
    @Override
    public void run() {
        System.out.println("in run()-about to sleep for 20 seconds");
        try {
            Thread.sleep(2000);
            System.out.println("in run() -woke up");
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("in run() - interrupted while sleeping");
            //处理完中断异常后返回到run()方法入口
            return;
        }
        System.out.println("in run() -leaving normally");

    }

    public static void main(String[] args) {
        JavaInterrupt si = new JavaInterrupt();
        Thread t = new Thread(si);
        t.start();
        //主线程休眠2秒，从而确保刚才启动的而现场右机会执行一段时间

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("in main()-interrupting other thread");
        //中断线程t
        t.interrupt();
        System.out.println("in main -leaving");

    }
}
