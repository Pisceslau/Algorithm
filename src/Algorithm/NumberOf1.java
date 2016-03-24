package Algorithm;

/**
 * Created by Lunar on 2016/3/7.
 * 剑指Offer中的第十题：输入一个整数输出该数中的二进制的1的个数
 * 二进制中的一个数，考察位运算
 */
public class NumberOf1 {
    //常规解法为了避免右移动数字n造成负数n的首数一直为1造成死循环，我们把1左移
    public int numberOf1(int n) {
        int flag = 1;
        int count = 0;//1的个数
        while (flag>0) {
            if ((n & flag) >= 1)
                count++;
            flag = flag << 1;
        }
        return count;

    }

    //一个数的二进制-1然后与原数与运算后的结果使整数最右边的1变为了0；
    public int numberOf1Best(int n) {
        int count = 0;
        while(n!=0){
            n = (n-1)&n;
            count ++;//每次少个1就count++最后说明少了几个1就是1 的个数
        }
        return count;
    }

    public static void main(String[] args) {
        int a = 15;
        NumberOf1 numberOf1 = new NumberOf1();
        System.out.print(numberOf1.numberOf1(a)+", ");
        System.out.print(numberOf1.numberOf1Best(a));

    }
}
