package Algorithm;

/**
 * Created by Lunar on 2016/4/9.
 * 剑指Offer第二十九题：数组中出现次数超过一半的数字
 * 基于快速排序的partition函数
 */
public class MoreThanHalfNumber {
    public static int partition(int[] a, int lo, int hi) {
        //二个指针
        if (lo == hi) {
            return a[lo];
        }
        int i = lo, j = hi + 1;
        //最低元素的值(初始切分值)
        int v = a[lo];
        while (true) {

            while (a[++i] < v) {
                //如果i到达最右边跳出此while
                if (i == hi) break;
            }

            while (a[--j] > v) {
                //如果右侧指针到达最左侧了，跳出此while
                if (j == lo) break;
            }
            //如果二个指针相遇了跳出整个大的while循环，执行最终的和初始切分值的交换动作

            if (i >= j) break;
            while (a[i] > a[j]) {
                //当左侧元素大于右侧元素则交换
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }
        //a[j]和初始切分值交换并返回j（下标）
        int t = a[lo];
        a[lo] = a[j];
        a[j] = t;
        return j;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        int[] b = {1};
        System.out.println(new MoreThanHalfNumber().moreThanHalfNumber(b));
    }

    //检查输入数组是不是违法的
    public boolean checkInvalidArray(int[] numbers) {
        boolean inputValid = false;
        if (numbers == null || numbers.length <= 0)
            inputValid = true;
        return inputValid;
    }

    //检查是不是数组中频率最高的数的都到不了数组长度的一半
    public boolean checkMoreThanHalf(int[] numbers, int number) {
        int times = 0;//频率设置为初始值0
        for (int i = 0; i < numbers.length; i++) {
            if (number == numbers[i]) {
                times++;
            }
        }
        if (times <= numbers.length >> 1)
            return false;
        return true;
    }

    public int moreThanHalfNumber(int[] numbers) {
        if (checkInvalidArray(numbers)) return 0;
        //保持partition的纯洁性。
        if (numbers.length == 1) return numbers[0];
        int middle = numbers.length >> 1;
        int start = 0;
        int end = numbers.length - 1;

        int index = partition(numbers, start, end);

        while (index != middle) {
            if (index > middle) {
                //如果index大于数组的中位数的坐标，则在数组的左边查找
                end = index - 1;
                index = partition(numbers, start, end);
            } else {
                start = index + 1;
                index = partition(numbers, start, end);
            }
        }
        int result = numbers[middle];
        if (!checkMoreThanHalf(numbers, result)) {
            result = 0;
        }
        return result;
    }
}
