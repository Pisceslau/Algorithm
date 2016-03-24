package sort;

/**
 * Created by Lunar on 2016/1/19.
 * 默写归并排序
 */
public class Merge1Again {
    public static int[] aux;

    public static void merge(int[] a, int lo, int mid, int hi) {

        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        for (int k = lo; k <= hi; k++) {
            if (i > mid) a[k] = aux[j++];//左边用完了，取右边
            else if (j > hi) a[k] = aux[i++];//右边用完了，取左边
            else if (aux[j] < aux[i]) a[k] = aux[j++];//右小于左，取右
            else a[k] = aux[i++];
        }
    }

    public static void sort(int[] a) {
        aux = new int[a.length];
        sort(a, 0, a.length - 1);
    }

    public static void sort(int[] a, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);

        merge(a, lo, mid, hi);
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 6, 4, 3, 6, 7, 6, 4, 5, 89, 45};
        sort(a);

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
