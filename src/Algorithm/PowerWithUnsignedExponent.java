package Algorithm;

/**
 * Created by Lunar on 2016/3/7.
 * 剑指Offer非负数的次方的快速方法
 */
public class PowerWithUnsignedExponent {
    public static double powerWithUnsignedExponent(double base, int exponent) {
        if (exponent == 0) return 1;
        if (exponent == 1) return base;

        double result = powerWithUnsignedExponent(base, exponent >> 1);
        result *= result;
        //如果是奇数
        if ((exponent & 0x1) == 1) {
            result = result * base;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.print(powerWithUnsignedExponent(2,3));
    }
}
