package Algorithm;

import java.util.Arrays;

/**
 * Created by Lunar on 2016/3/8.
 * 剑指Offer第12题打印1 到 最大的n位数如输入3，打印0-999
 */
public class PrintToMaxOfNDigits {
    //会溢出的情况Overflow
    public static void printToMaxOfNDigits(int n) {
        int number = 1;
        int i = 0;
        while (i++ < n) {
            number *= 10;
        }
        for (i = 1; i < number; i++) {
            System.out.print(i + ",");
        }
    }

    public static void printToMaxOfNDigitsBetter(int n) {
        if (n <= 0) return;//输入了0和负数
        char[] number = new char[n];
        Arrays.fill(number, '0');//给每个位置赋值字符’0’
        while (!increment(number)) {
            printNumber(number);
        }
        for (int i = 0; i < 10; i++) {
            number[0] = (char) (i + '0');
            printToMaxOfNDigitsRecursively(number, n, 0);
        }
    }

    //字符串上模拟数字的加法的解法，用字符串或者一个数组去表达一个大数
    //1.increment函数实现模拟在字符串的数字上的加法
    public static boolean increment(char[] number) {
        boolean isOverflow = false;
        int takeOver = 0;//进位数字
        int length = number.length;

        for (int i = length - 1; i >= 0; i--) {
            //i位也就是某一位的数字和(包括加了进位的)
            int nSum = number[i] - '0' + takeOver;
            if (i == length - 1)
                nSum++;
            //如果某位数字大于10说明要进位了
            if (nSum >= 10) {
                //如果进位后会在第一位置,说明已经达到了最大值n个9
                if (i == 0) {
                    isOverflow = true;
                }
                //如果没有在第一位进行进位活动
                else {
                    nSum -= 10;
                    takeOver = 1;
                    number[i] = (char) ('0' + nSum);
                }

            }//若没进位
            else {
                number[i] = (char) ('0' + nSum);
                break;//当前面的位不变的时候，后面的位一直加则一直跳出for，然后打印之然后重新for循环，i为最末的位0-9
            }

        }
        return isOverflow;
    }

    //如果首数字为0则不打印‘的方法
    public static void printNumber(char[] number) {
        boolean isBeginning0 = true;
        int nLength = number.length;
        for (int i = 0; i < nLength; i++) {
            //这个不等要是字符‘0’才行！否则还是会打印第一位有0的数字
            if (isBeginning0 && number[i] != '0')
                isBeginning0 = false;
            if (!isBeginning0) {
                System.out.print(number[i]);
            }
        }
        System.out.print("\t");

    }

    //递归方式实现
    public static void printToMaxOfNDigitsRecursively(char[] number, int length, int index) {
        if (index == length - 1) {
            printNumber(number);
            return;
        }
        for (int i = 0; i < 10; i++) {
            number[index + 1] = (char) (i + '0');
            printToMaxOfNDigitsRecursively(number, length, index + 1);
        }
    }

    public static void main(String[] args) {
        printToMaxOfNDigitsBetter(3);
    }
}