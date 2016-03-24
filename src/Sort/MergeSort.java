package Sort;

import java.util.Arrays;

/**
 * Created by Lunar on 2016/3/13.
 * 排序算法之归并排序，原地归并
 */
public class MergeSort {
    //不能直接merge方法就是归并排序了，如果左右两个数组是有序的这就可以了
    public static int[] aux;

    public static void merge(int a[], int lo, int mid, int hi) {
        //把数组赋值到辅助数组里
        int i = lo;//前数组的指针,不能为0因为不是整个数组啊！！！而是分的，lo自然不一样！
        int j = mid + 1;//右数组的起始指针位置
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];//这里lo,也不能是0！因为是分数组啊！
        }
        //在辅助数组中进行归并挑选小的元素放置在在相应位置上

        for (int k = lo; k <= hi; k++) {
            //如果左边用完了则取右边元素，并指向下一个指针
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];//如果右边数组的指针越界用完了，则使用左边的数组
            else if (aux[i] < aux[j]) a[k] = aux[i++];//如果左边的数小于右边则使用小的左边
            else a[k] = aux[j++];
        }
    }

    public static void main(String[] args) {
        int[] a = {9, 8, 7, 6, 5, 4, 3, 2, 6, 1, 0};

        System.out.println("Before sort:");
        System.out.println(Arrays.toString(a));

        sort(a);
        System.out.println("After sort:");
        System.out.println(Arrays.toString(a));
    }

    public static void sort(int[] a) {
        aux = new int[a.length];
        sort(a, 0, a.length - 1);
    }

    private static void sort(int[] a, int lo, int hi) {

        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        merge(a, lo, mid, hi);
    }
}
