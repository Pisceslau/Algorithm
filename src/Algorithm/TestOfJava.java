package Algorithm;

/**
 * Created by Lunar on 2016/10/12.
 */
public class TestOfJava {
    int a = 4, b = 5, d = 6;

    public int f(int a) {
        int b = 0;
        b++;
        return b;
    }

    public int d() {
        int i = 0;
        return (i++ > 0) || (i++ <= 0) ? (++i * 2) : (i - 1);
    }

    public static void main(String[] args) {
        int a = 2;
        int i;
        TestOfJava java = new TestOfJava();
        for (i = 0; i < 3; i++) {
            System.out.println(java.f(a));
        }


        System.out.println(java.d());


    }
}
