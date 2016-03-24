package Algorithm;

/**
 * Created by Lunar on 2016/3/7.
 * 判断这个数是不是2的整数次方
 * 剑指Offer82页相关题目1
 */
public class PowerOf2 {
     static  boolean  isPowerOf2(int n) {
        int count = 0;
        while (n != 0) {
            n = (n - 1) & n;
            count++;
        }
        if (count == 1) return true;
        else return false;
    }
    public static void main(String[] args) {
        System.out.print(isPowerOf2(8));
    }
}
