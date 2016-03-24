package Algorithm;

/**
 * Created by Lunar on 2016/3/7.
 * 数值的x次方
 */
public class Power {
    //方法1
    boolean inValidInput = false;//不违法输入

    /*
    * @param: 基底和次方*/
    public double power(double base, int exponent) {
        //0的0次方在数学上是没有意义的
        if (equal(base, 0.0) && exponent == 0) {
            inValidInput = true;//输入非法了
            return 0.0;
        }
        //指数小于0则先取绝对值然后取倒数
        if (exponent < 0) {
            int absExponent = -exponent;
            return 1 / (powerNormal(base, absExponent));
        } else {
            return powerNormal(base, exponent);
        }
    }

    //没问题的方式
    double powerNormal(double base, int exponent) {
        double result = 1.0;
        for (int i = 1; i <= exponent; i++) {
            result *= base;
        }
        return result;
    }


    //判断浮点数是否相等不能==只能在以精度的范围内
    public  static boolean equal(double one, double two) {
        if (one - two > -0.0000001 && one - two < 0.0000001) return true;
        else return false;
    }

    public static void main(String[] args) {
        Power p = new Power();
        System.out.println(p.power(3,3));
        System.out.print(p.power(3,-1));
    }
}
