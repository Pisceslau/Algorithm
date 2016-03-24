package OthersAboutJava;

/**
 * Created by Lunar on 2016/3/15.
 * 自增运算符
 */
public class AutoIncrement {
    public static void main(String[] args) {
        //单独进行a--和--a是一样的
        int a = 9, b = 9;
        a--;
        --b;
        System.out.println(a + " " + b);
        //如果是赋值的话就不一样
        int c = a--;
        int d = --b;
        System.out.print(c+" "+d);
    }

    
}