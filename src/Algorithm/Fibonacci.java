package Algorithm;

/**
 * Created by Lunar on 2016/3/7.
 *剑指Offer第九题：Fibonacci数列的非递归实现
 */
public class Fibonacci {
    public static int fibonacci(int n) {
        int[] result = {0, 1};
        if (n < 2) {
            return result[n];
        }
        int oneNum = 0;
        int twoNum = 1;
        int fib = 0;
        for(int i = 2;i<=n;i++){
            fib = oneNum + twoNum;
            oneNum = twoNum;
            twoNum = fib;
        }
        return fib;
    }
    public static void main(String[] args) {
        System.out.print(fibonacci(5));
    }
}
