package OthersAboutJava;


/**
 * Created by Lunar on 2016/3/12.
 * Java生产者消费者模式
 */
class Info {
    /*信息类*/
    public String name = "name";
    public String content = "content";
    public boolean flag = true;//设立标志位，if（true）初始时先生产


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public synchronized void set(String name, String content) {
        while (!flag) {
            try {
                //阻塞
                super.wait();//调用Object父类的wait方法
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        this.setName(name);//设置名称
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.setContent(content);//设置内容
        flag = false;//改变标志位可以取走,执行此时候跑到上面的阻塞while循环内
        super.notify();

    }

    public synchronized void get() {
        while (flag) {
            try {
                super.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.getName() + "--->" + this.getContent());
        flag = true;//改变标志位 表示可以生产
        super.notify();
    }
}

//生产者类是一个线程
class Producer implements Runnable {
    private Info info = null;

    public Producer(Info info) {
        this.info = info;
    }

    @Override
    public void run() {
        //交替生产二种产品
        boolean flag = true;//定义标志位
        for (int i = 0; i < 10; i++) {
            if (flag) {
                this.info.set("姓名--1", "内容--1");
                flag = false;
            } else {
                this.info.set("姓名--2", "内容--2");
                flag = true;
            }
        }
    }
}

//消费者类
class Consumer implements Runnable {
    private Info info = null;

    public Consumer(Info info) {
        this.info = info;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            this.info.get();
        }
    }

}

//Demo 类
public class ThreadClassDemo {
    public static void main(String[] args) {
        Info info = new Info();//实例化Info对象
        Producer pro = new Producer(info);//生产者
        Consumer con = new Consumer(info);//消费者
        new Thread(pro).start();
        //启动了生产者线程后，睡5秒再启动消费者线程
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(con).start();
    }
}