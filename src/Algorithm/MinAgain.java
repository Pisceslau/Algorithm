package Algorithm;

/**
 * Created by Lunar on 2016/3/8.
 * 剑指Offer第八题Again
 */
public class MinAgain {
    public static int min(int[] numbers, int length) {
        if (numbers == null || length <= 0) {
            return 0;
        }
        //初始化
        int index1 = 0;
        int index2 = length - 1;
        int indexMid = index1;//Mid值初始为index1，因为移动0个元素也是满足情况的所以整个数组是个递增的，说明第一个
        //元素是最小的


        while (numbers[index1] >= numbers[index2]) {
            if (index2 - index1 == 1) {
                indexMid = index2;
                break;
            }
            //如果前后中指针指向的元素都一样那么只能顺序查找
            indexMid = (index1 + index2) / 2;
            if (numbers[index1] == numbers[index2] && numbers[index2] == numbers[indexMid])
                return minInOrder(numbers, index1, index2);
            //若中间元素大于第一个元素则中间元素属于前面的递增序列，而整个数组的最小的元素在中间元素的后面
            if (numbers[indexMid] >= numbers[index1])
                index1 = indexMid;
                //若中间元素小于第二个指针所指的元素则中间元素属于后面递增序列，而小元素在前面
            else if (numbers[indexMid] <= numbers[index2])
                index2 = indexMid;
        }
        return numbers[indexMid];

    }

    static int minInOrder(int[] numbers, int index1, int index2) {
        int result = numbers[index1];
        for (int i = index1 + 1; i <= index2; i++) {
            if (numbers[i] < result)
                result = numbers[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        System.out.print(min(a, a.length));
    }
}
