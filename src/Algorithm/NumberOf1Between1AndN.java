package Algorithm;

/**
 * Created by Lunar on 2016/3/25.
 * 剑指Offer第三十二题：从1到n整数中1出现的次数
 * 输入一个整数n，求从1到n这n个整数的十进制表示中1出现的次数，例如输入12，从1到12
 * 这些整数中包含1的数字有1,10,11和12，1总共出现了5次
 */
public class NumberOf1Between1AndN {
    //不考虑时间效率的解法
    static int numberOf1Between1AndN(int n) {
        int number = 0;
        for (int i = 1; i <= n; i++) {
            number += numberOf1(i);
        }
        return number;
    }

    //求number的错误方法，因为这个while循环不一定执行，while里是循环的条件，if里是某个特点的数的条件
    static int numberOf1W(int n) {
        int number = 0;
        while (n % 10 == 1) {
            number++;
            n = n / 10;
        }
        return number;
    }

    static int numberOf1(int n) {
        int number = 0;

        while (n != 0) {
            if (n % 10 == 1)
                number++;
            n = n / 10;
        }
        return number;
    }

    public static void main(String[] args) {
        System.out.println(numberOf1Between1AndN(12));
        /*System.out.println(numberOf1(12));
        System.out.println(numberOf1W(12));*/

    }

    //从数字规律着手明显提高时间效率的解法
    //（1）10的次方
    int powerOf10(int n) {
        int result = 1;
        for (int i = 0; i < n; i++) {
            result *= 10;
        }
        return result;
    }

}
