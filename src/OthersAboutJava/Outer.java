package OthersAboutJava;

/**
 * Created by Lunar on 2016/4/3.
 * 匿名内部类
 */
public class Outer {
    public Inner getInnerClass(final int num, String str) {
        return new Inner() {
            int number = num + 3;

            @Override
            public int getNumber() {
                return number;
            }
        };
    }

    public static void main(String[] args) {
        Outer out = new Outer();
        Outer.Inner inner = out.getInnerClass(2, "Liu");
        System.out.print(inner.getNumber());

    }

    interface Inner {
        int getNumber();
    }
}
