package Algorithm;

/**
 * Created by Lunar on 2016/3/7.
 * 剑指Offer第八题：
 */
public class Min {
    public static int min(int[] numbers, int length) {
        if (numbers == null || length <= 0) {
            return 0;
        }
        int index1 = 0;
        int index2 = length - 1;
        int indexMid = index1;
        while (numbers[index1] >= numbers[index2]) {
            if (index2 - index1 == 1) {
                indexMid = index2;
                break;
            }

            indexMid = (index1 + index2) / 2;
            //使用minInOrder的情况。
            if (numbers[index1] == numbers[index2] && numbers[indexMid] == numbers[index1]) {
                return minInOrder(numbers, index1, index2);
            }
            if (numbers[indexMid] >= numbers[index1]) {
                //中间值大于前面
                index1 = indexMid;
            } else if (numbers[indexMid] <= numbers[index2]) {
                index2 = indexMid;
            }
        }
        return numbers[indexMid];
    }

    //若首尾元素和中间元素相同则无法知道中间元素属于哪个子数组，使用如下顺序查找的方法。
    static int minInOrder(int[] numbers, int index1, int index2) {
        int result = numbers[index1];
        for (int i = index1 + 1; i <= index2; ++i) {
            if (numbers[i] < result) {
                result = numbers[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = {3, 4, 5, 1, 2};
        int[] b = {1, 1, 1, 0, 1};
        System.out.println(min(a, a.length));
        System.out.print(min(b, b.length));
    }
}
