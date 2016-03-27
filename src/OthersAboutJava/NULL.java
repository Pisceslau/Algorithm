package OthersAboutJava;

/**
 * Created by Lunar on 2016/3/27.
 * Java面试宝典题
 * P117 null值可以转换为任何Java类型，但是null转换后的值是无效对象，其返回值还是null
 * 而static方法调用和类名绑定，不借助对象进行访问，所以能正常输出，如果不是static则不能输入
 * ,报空指针错误
 */
public class NULL {
    public static void haha() {
        System.out.println("haha");
    }

    public void nohaha() {
        System.out.print("nohaha");
    }

    public static void main(String[] args) {
        ((NULL) null).haha();
        //((NULL)null).nohaha();
    }
}
