package Sort;

import java.util.Arrays;

/**
 * Created by Lunar on 2016/3/13.
 * 计数排序（《算法》第四版中为键索引计数排序算法）
 * 思想：原数组中的每个数都在一个范围内，比如26个字母都在这字母范围里
 * 新建一个辅助数组（长度为范围+1，加一的原因是计算排位（rank)时候可以-1）为原数组中每个元素的
 * 频率
 * 然后根据这个辅助数组计算每个元素的排位，也就是排名
 * 新建个辅助临时数组根据原数组中的值，第一个辅助数组排位信息找到位置信息，将这个数字放临时
 * 数组中的正确的位置上，然后排位辅助数组的元素减去1个（每放一个减少一个）
 * 然后回写，将辅助数组的数每一个都回写到原来的数组中去
 */
public class CountSort {
    public static void countSort(int[] a, int range) {
        //新建一个辅助数组用于计算频率和排位，元素个数为range+1;
        int[] count = new int[range + 1];//每一位自动赋值为0
        //遍历原数组，取得频率信息
        for (int i = 0; i < a.length; i++) {
            int value = a[i];
            if (value < 0 || value > range) {
                System.out.println("数组中元素不在范围之间");
            }
            count[value] += 1;//相应的下标代表这原数组中的那个元素，而值则代表着这个元素的出现频率
        }
        //将辅助数组中的频率信息转化为排位信息
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
        //将辅助数组排位信息和原数组中的值得到在辅助数组temp中的正确位置,从后向前
        int[] temp = new int[a.length];
        for (int i = a.length - 1; i >= 0; i--) {
            int value = a[i];
            int position = count[value]-1;//注意这里是-1，因为第二个数字代表的是原数组第一个数字的排名信息
            temp[position] = value;
            count[value]-=1;
        }
        //回写：将辅助数组temp的元素写回到原始数组
        for (int i = 0; i < a.length; i++) {
            a[i] = temp[i];
        }
    }

    public static void main(String[] args) {
        int[] array = {9, 8, 7, 6, 5, 4, 3, 2, 6, 1, 0};

    System.out.println("Before sort:");
    System.out.println(Arrays.toString(array));

    countSort(array, 9);

    System.out.println("After sort:");
    System.out.println(Arrays.toString(array));
}

}
