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
        while (numbers[index1] > numbers[index2]) {
            if (index2 - index1 == 1) {
                indexMid = index2;
                break;
            }

            indexMid = (index1 + index2) / 2;
            if (numbers[indexMid] >= numbers[index1]) {
                //中间值大于前面
                index1 = indexMid;
            } else if (numbers[indexMid] <= numbers[index2]) {
                index2 = indexMid;
            }
        }
        return numbers[indexMid];
    }

    public static void main(String[] args) {
        int[] a = {3, 4, 5, 1, 2};
        System.out.print(min(a, a.length));
    }
}
