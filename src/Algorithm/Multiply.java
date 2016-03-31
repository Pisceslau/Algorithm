package Algorithm;

import java.util.Arrays;

/**
 * Created by Lunar on 2016/3/31.
 * 剑指Offer第五十二题：构建乘积数组
 * 思路：把i前边先算出来，后面再算出来然后乘积
 */
public class Multiply {
    static double[] multiply(double[] array1) {
        int length1 = array1.length;
        double[] array2 = new double[length1];

        if (length1 > 1) {
            array2[0] = 1;
            //double temp1 = 1;
            //.因为之前的B[i]=C[i],所以让B[i]×D[i]就是要保存的结果
            for (int i = 1; i < length1; i++) {
                /*temp1 *= array1[i - 1];
                array2[i] *= temp1;*/
                array2[i] = array2[i - 1] * array1[i - 1];
            }
            //temp相当于D[i], tmp保存array1[n-1]*array1[n-2]...array1[i+1]的结果
            double temp = 1;
            for (int i = length1 - 2; i >= 0; i--) {
                temp *= array1[i + 1];
                array2[i] *= temp;
            }

        }
        return array2;
    }

    public static void main(String[] args) {
        double[] a = {2, 1, 3, 2, 1};
        System.out.println(Arrays.toString(multiply(a)));

    }

}
