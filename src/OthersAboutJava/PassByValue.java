package OthersAboutJava;

/**
 * Created by Lunar on 2016/3/27.
 * Java pass by value：副本传递
 * Java参数传值的，基本类型一个副本不改变原来
 * String，Integer，StringBuffer等引用类传值，这个值是引用副本？
 * String,Integer不变，StringBuffer，数组，类等改变了。
 */
public class PassByValue {
    public static void main(String[] args) {
        int a = 1;
        String s = "String is pass by value,but it is immutable";
        Integer integer = 1;

        StringBuffer buffer = new StringBuffer("Java");
        System.out.println("Before:" + a);
        add(a);
        System.out.println("After:" + a);

        //字符串 String
        System.out.println(s);
        addString(s);
        System.out.println(s);
        //StringBuffer
        System.out.println(buffer);
        addStringBuffer(buffer);
        System.out.println(buffer);
        //Integer
        System.out.println(integer);
        addInteger(integer);
        System.out.println(integer);
    }

    public static void add(int b) {
        b = b + 1;
    }

    public static void addString(String s) {
        s = s + "???";
    }

    public static void addStringBuffer(StringBuffer s) {
        s = s.append("is a good man.");
    }

    public static void addInteger(Integer i) {
        i += 1;
    }
}
