package Algorithm;

/**
 * Created by Lunar on 2016/3/9.
 * 剑指Offer47不用加减乘除做加法
 * 思路如下：两个数的加法过程与其二进制的加法过程是一致的
 * 二进制的加法如果不进位的位各个位的异或运算
 * 如果是进位（相与然后结果左边移动）的话二者（进位的结果和异或的结果）相加（相异或）不再进行相加（异或）的
 * 条件是进位为0了就是说没有进位
 */
public class Add {
    public static int add(int num1, int num2) {
        int sum, carry;//和与进位
        do {
            //模拟加法
            sum = num1 ^ num2;
            //模拟进位
            carry = (num1 & num2) << 1;
            //进位与和重新相加（相异或）把二者赋值为num1 ,num2进行（加法）活动
            num1 = sum;
            num2 = carry;
        } while (num2 != 0);
        return sum;//返回num1也可以因为num1 = sum值一样的
    }

    public static void main(String[] args) {
        System.out.println(add(17, 5));
    }
}
