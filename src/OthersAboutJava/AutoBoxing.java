package OthersAboutJava;

/**
 * Created by Lunar on 2016/4/4.
 * 自动装箱的陷阱
 */
public class AutoBoxing {
    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 127;
        Integer f = 127;
        Integer g = 128;
        Integer h = 128;
        Integer j = new Integer(127);
        Integer k = new Integer(127);
        Integer m = new Integer(128);
        Integer n = new Integer(128);
        Long i = 3L;
        System.out.println(c == d);//==两边都是包装，缓存情况（非new）：猜想为false,结果为true，缓存：-128到127是true，之后为false
        System.out.println(e == f);//true
        System.out.println(g == h);//false
        System.out.println(j == k);//两边都是包装情况，new false
        System.out.println(m == n);
        System.out.println(c == (a + b));
        System.out.println(c.equals(a + b));
        System.out.println(i == (a + b));
        System.out.println(i.equals(a + b));//==单边包装另一半为原始，包装转为原始
        /*

Unboxing will be happening when arithmetic operators, comparison operators appear.

eg:

Integer a = 10;
a = a+10; //1.unboxing a to int 2.calculate a+10 3.boxing 20 to Integer.
System.out.print(a > 10); //1.unboxing a to int 2. compare
But when == appear, it depends.

If boxing type appear on both side, it will compare the reference.But if base type appear on one side, and the other side is a boxing type, the boxing type will unboxing to base type.

eg:

Integer a = new Integer(129);
Integer b = new Integer(129);
System.out.println(a == b); // compare reference return false
System.out.println(a == 129); // a will unboxing and compare 129 == 129 return true
PS: In Java.lang.Integer Cache to support the object identity semantics of autoboxing for values between -128 and 127 (inclusive) as required by JLS. See source code

So:

Integer a = 127;
Integer b = 127; //cached, the same as b a==b return ture

Integer c = 129;
Integer d = 129; // not cached, c==d return false*/
    }
}
