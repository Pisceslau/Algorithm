package OthersAboutJava;

import java.math.BigInteger;

/**
 * Created by Lunar on 2016/3/26.
 * Java程序员面试宝典中P196：大数类操作返回结果，不返回原来值，如果想返回，必须显式返回
 */
public class JavaBigInteger {
    public static void main(String[] args) {
        BigInteger one = new BigInteger("1");
        BigInteger two = new BigInteger("2");
        BigInteger three = new BigInteger("3");
        BigInteger sum = new BigInteger("0");

        sum.add(one);
        sum.add(three);
        sum.add(two);
        System.out.println(sum.toString());
        //若想返回6
        sum = sum.add(one);
        sum = sum.add(three);
        sum = sum.add(two);
        System.out.println(sum.toString());
    }
}
