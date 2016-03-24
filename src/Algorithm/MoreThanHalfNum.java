package Algorithm;

/**
 * Created by Lunar on 2016/3/20.
 * 出现超过数组一半的数字
 */
public class MoreThanHalfNum {
    static int moreThanHalfNum(int[] numbers) {
        if (numbers == null) return 0;
        int result = numbers[0];
        int times = 1;
        for (int i = 1; i < numbers.length; i++) {
            if (times == 0) {
                result = numbers[i];
                times = 1;
            } else if (numbers[i] == result) {
                times++;
            } else times--;
        }
        //如果次数没有到达一半，则check函数会为false，要想执行，if需要true，所以！了！！！！！！！！
        if (!checkMoreThanHalf(numbers, result))
            result = 0;
        return result;
    }

    //检查这个数是否是超过了数组的一半
    static boolean checkMoreThanHalf(int[] numbers, int number) {
        int times = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == number) {
                times++;
            }
        }
        boolean isMoreThanHalf = true;
        if (times * 2 <= numbers.length) {
            isMoreThanHalf = false;
        }
        return isMoreThanHalf;

    }

    public static void main(String[] args) {
        int[] a = {1,2,3};
        int[] b = {1,2,2,2,2,4,5};
        System.out.println(moreThanHalfNum(a));
        System.out.println(moreThanHalfNum(b));
    }
}
