package OthersAboutJava;

/**
 * Created by Lunar on 2016/3/12.
 * Java多线程的二种方法之使用Runnable接口
 */
public class MyThreadByImplementsRunnable implements Runnable {
    private  int ticket=10;
    public static void main(String[] args) {
        MyThreadByImplementsRunnable thread = new MyThreadByImplementsRunnable();
        Thread thread1 = new Thread(thread);
        Thread thread2 = new Thread(thread);
        Thread thread3 = new Thread(thread);

        thread1.start();
        thread2.start();
        thread3.start();
    }

    @Override
    public void run() {
        for(int i=0;i<500;i++)
        {
            if(this.ticket>0)
            {
                System.out.println("卖票----->"+(this.ticket--));
            }
        }
    }
}
