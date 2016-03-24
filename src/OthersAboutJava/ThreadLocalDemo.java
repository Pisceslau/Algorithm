package OthersAboutJava;

/**
 * Created by Lunar on 2016/3/20.
 * Java学习之ThreadLocal
 * ThreadLocal允许我们创建只能被同一个线程访问的对象，就算多个线程
 * 同时访问这个对象或者变量，或设置值，每个线程仅仅访问到自己的
 * 不能互相访问的，起到了隔离的作用
 */
public class ThreadLocalDemo {
    public static void main(String[] args) {
       /* ThreadLocal<String> myThreadLocal = new ThreadLocal<>();
        //设置值
        myThreadLocal.set("A ThreadLocal");
        //访问值
        String theradLocalValue = myThreadLocal.get();

        ThreadLocal myThreadLocal2 = new ThreadLocal() {
            @Override
            protected String initialValue() {
                return "This is the initial value";
            }
        };*/
        MyRunnable sharedRunnableInstance = new MyRunnable();
        Thread thread1 = new Thread(sharedRunnableInstance);
        Thread thread2 = new Thread(sharedRunnableInstance);
        thread1.start();
        thread2.start();
    }

}

     class MyRunnable implements Runnable {
        private ThreadLocal threadLocal = new ThreadLocal();

        @Override
        public void run() {
            threadLocal.set((int) (Math.random() * 100D));

            try {

                Thread.sleep(2000);

            } catch (InterruptedException e) {

            }

            System.out.println(threadLocal.get());
/*
* 上面的例子创建了一个MyRunnable实例，并将该实例作为参数传递给两个线程。
* 两个线程分别执行run()方法，并且都在ThreadLocal实例上保存了不同的值。如果它们访问
* 的不是ThreadLocal对象并且调用的set()方法被同步了
* ，则第二个线程会覆盖掉第一个线程设置的值。
* 但是，由于它们访问的是一个ThreadLocal对象，
* 因此这两个线程都无法看到对方保存的值。也就是说，它们存取的是两个不同的值。
* */
        }
    }

