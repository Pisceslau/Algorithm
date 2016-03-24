package Sort;

/**
 * Created by Lunar on 2016/3/15.
 * 堆排序 练习 大顶堆
 */
public class HeapSort {
    public static void heapSort(int[] a) {
        //第一阶段把数组中杂乱的数据构造一个根结点为最大元素的堆,因为下沉操作不用叶子结点，而叶子结点数目为N/2所以从a.length/2
        //构造
        int N = a.length-1;//可以使用的元素个数
        for (int i = N / 2; i >= 1; i--) {
            sink(a,i,N);
        }
        //第二阶段排序
        while (N > 1) {
            exch(a, 1, N--);

            sink(a,1,N);
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

    private static void exch(int[] a, int k, int j) {
        int temp = a[k];
        a[k] = a[j];
        a[j] = temp;
    }

    private static boolean less(int[] a, int j, int i) {
        return a[j]<a[i];
    }
    public static void main(String[] args) {
        int[] a = {1, 3, 5, 3, 5, 567, 78, 27, 8, 7, 3, 8,8,9,4,5,90,45,67,32,2,3};
        heapSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }

    }
}
