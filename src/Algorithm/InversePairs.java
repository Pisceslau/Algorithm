package Algorithm;

/**
 * Created by Lunar on 2016/3/25.
 * 剑指Offer第三十六题：数组中的逆序对
 * 在数组中的两个数字如果前面一个数字大于后面的数字，则这二个数字构成一个逆序对，输入
 * 一个数组，求出这个数组中的逆序对的总数
 * <p>
 * 思路：
 * 把数组分隔为子数组，先统计出子数组内部的逆序对总数，然后再
 * 统计出两个相邻子数组之间的逆序对的数目，在统计逆序对的过程中，还需要对数组进行排序（使用额外的空间的归并排序）
 * 有个疑问：为什么inversePairsCore递归时候copy在前？先复习归并排序吧
 */
public class InversePairs {
    private static int inversePairsCore(int[] data, int[] copy, int start, int end) {
        //只有一个元素的数组，逆序对自然为0
        if (start == end) {
            copy[start] = data[start];
            return 0;
        }
        int length = (end - start) / 2;//每组的长度
        //左边数组的逆序对数，递归
        int left = inversePairsCore(copy, data, start, start + length);
        int right = inversePairsCore(copy, data, start + length + 1, end);
        int i = start + length;
        //j 初始化为后半段最后一个数字的下标
        int j = end;
        int indexCopy = end;//辅助数组的最后一个下标初始化
        int count = 0;
        while (i >= start && j >= start + length + 1) {
            if (data[i] > data[j]) {
                //如果前最后大于后数组的最后说明逆序对数目为后数组的元素个数
                copy[indexCopy--] = data[i--];
                count += j - start - length;
            } else {
                //如果前面小于后面不构成逆序对，则放入辅助数组中，相应的后面的也会前移，直到前大于后了
                copy[indexCopy--] = data[j--];
            }
        }
        //得到逆序对后，左边有序放入数组
        for (; i >= start; i--) {
            copy[indexCopy--] = data[i];
        }
        //得到排序对后，右边有序放入数组
        for (; j >= start + length + 1; j--) {
            copy[indexCopy--] = data[j];
        }
        return left + right + count;

    }

    public static int inversePairs(int[] data) {
        if (data == null) return 0;
        int length = data.length;
        if (length < 0) return 0;

        int[] copy = new int[length];
        for (int i = 0; i < length; i++) {
            copy[i] = data[i];
        }
        int count = inversePairsCore(data, copy, 0, length - 1);
        return count;
    }

    public static void main(String[] args) {
        int[] a = {7, 5, 6, 4};
        System.out.print(inversePairs(a));
    }
}
