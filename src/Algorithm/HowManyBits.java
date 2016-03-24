package Algorithm;

/**
 * Created by Lunar on 2016/3/7.
 * 剑指Offer82页二题
 * 输入两个数m, n 判断改变多少位数才能使m变为n
 * 思路：两个数异或：异或是相同为0不同结果为1
 * 所以1 的个数为改变的位数
 * 1的个数的求法在前面提到了
 */
public class HowManyBits {
    static int howManyBits(int m, int n) {
        int result = m ^ n;
        int count = 0;
        while (result != 0) {
            result = (result - 1) & result;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.print(howManyBits(13, 10));
    }
}
