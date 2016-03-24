package Algorithm;

/**
 * Created by Lunar on 2016/3/24.
 * 取得第1500个丑数
 * 丑数：只能被2,3,5整除的数
 * PS:第一种方式确实很费时间，运行很长时间才出结果。
 */
public class GetUglyNumber {
    //常规解法，直观而不高效，因为一些不是丑数的数也会进行计算，效率不高
    //判断一个数是不是丑数的方法
    static boolean isUglyNumber(int number) {
        while (number % 2 == 0)
            number /= 2;
        while (number % 3 == 0)
            number /= 3;
        while (number % 5 == 0)
            number /= 5;
        return number == 1;
    }

    //得到第几个丑数
    static int getUglyNumber(int index) {
        if (index <= 0) return 0;

        int number = 0;
        int i = 0;
        while (i < index) {
            number++;
            if (isUglyNumber(number))
                i++;
        }
        return number;
    }

    public static void main(String[] args) {
        System.out.println(getUglyNumber(1500));
        System.out.println(getUglynumberSolution2(1500));

    }

    //三个数中的最小的数
    static int min(int number1, int number2, int number3) {
        int min = (number1 < number2) ? number1 : number2;
        min = (min < number3) ? min : number3;
        return min;
    }

    //创建数组保存已经找到的丑数，用空间换时间的解法
    static int getUglynumberSolution2(int index) {
        if (index <= 0) return 0;
        int[] uglyNumbers = new int[index];
        uglyNumbers[0] = 1;//第一个元素为1；
        int nextUglyIndex = 1;
        int i = 0, j = 0, k = 0;

        while (nextUglyIndex < index) {
            int min = min(uglyNumbers[i] * 2, uglyNumbers[j] * 3, uglyNumbers[k] * 5);
            uglyNumbers[nextUglyIndex] = min;
            while (uglyNumbers[i] * 2 <= uglyNumbers[nextUglyIndex])
                i++;
            while (uglyNumbers[j] * 3 <= uglyNumbers[nextUglyIndex])
                j++;
            while (uglyNumbers[k] * 5 <= uglyNumbers[nextUglyIndex])
                k++;

            nextUglyIndex++;
        }
        int ugly = uglyNumbers[index - 1];
        return ugly;

    }
}
