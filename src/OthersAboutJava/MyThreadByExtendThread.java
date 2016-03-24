package OthersAboutJava;

/**
 * Created by Lunar on 2016/3/12.
 * 实现多线程的第一种方法：继承Thread
 */
public class MyThreadByExtendThread extends Thread {

    private String name;

    public MyThreadByExtendThread(String name) {
        super(name);
        this.name = name;
    }

    public static void main(String[] args) {
      /* MyThreadByExtendThread thread1 = new MyThreadByExtendThread("线程1");
        MyThreadByExtendThread thread2 = new MyThreadByExtendThread("线程2");
        MyThreadByExtendThread thread3 = new MyThreadByExtendThread("线程3");*/
        Runnable run1 = new MyThreadByExtendThread("线程1");
        Runnable run2 = new MyThreadByExtendThread("线程2");
        Runnable run3 = new MyThreadByExtendThread("线程3");

        Thread thread1 = new Thread(run1);
        Thread thread2 = new Thread(run2);
        Thread thread3 = new Thread(run3);

        thread1.start();
        thread2.start();
        thread3.start();
    }

    @Override
    public void run() {
        super.run();

        //打印输出
        for (int i = 0; i < 10; i++) {
            System.out.println(this.name + "----->运行、、、、");
        }

    }
}