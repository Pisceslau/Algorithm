package Sort;

/**
 * Created by Lunar on 2016/1/22.
 * 堆排序
 */
public class Heap {
    public static void sort(int[] a) {
        int N = a.length-1;
        for (int k = N / 2; k >= 1; k--) {
            sink(a, k, N);
        }
        //第二阶段
        while (N > 1) {
            exch(a, 1, N--);
            sink(a, 1, N);
        }
    }

    //改进参数的sink
    public static void sink(int[] a, int k, int N) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(a, j, j + 1)) j++;

            if (!less(a, k, j)) break;//如果父大于子，则跳出while循环
            exch(a, k, j);
            k = j;
        }
    }


    public static void exch(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static boolean less(int[] a, int i, int j) {
        return a[i] < a[j];
    }


    public static void main(String[] args) {
        int[] a = {1, 3, 5, 3, 5, 567, 78, 27, 8, 7, 3, 8,8,9,4,5,90,45,67,32,2,3};
        sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }

    }
}
