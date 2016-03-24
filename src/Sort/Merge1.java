package Sort;

/**
 * Created by Lunar on 2016/1/19.
 * Merge原地归并排序,自顶向下归并排序
 * Merge方法是两个“有序”的数组进行归并为一个有序的数组
 */
public class Merge1 {

    private static int[] aux;

    public static void merge(int[] a, int lo, int mid, int hi) {
        //复制到aux中

        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        for (int k = lo; k <= hi; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (aux[j] < aux[i]) a[k] = aux[j++];
            else a[k] = aux[i++];

        }
    }

    public static void sort(int[] a) {
        aux = new int[a.length];//一次性分配空间
        sort(a, 0, a.length - 1);
    }

    private static void sort(int[] a, int lo, int hi) {
        //将数组a[lo..hi]排序
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        merge(a, lo, mid, hi);

    }

    public static void main(String[] args) {
        int[] a = {9, 8, 7, 6, 5, 4, 3, 2, 6, 1, 0};
        //可以分为两个有序的子数组然后merge
        //nt[] b = {1, 1, 5, 6, 8, 9, 3, 7, 11, 12,15};

        //merge(b, 0, b.length / 2, b.length - 1);
        sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");

        }
        /*System.out.println();
        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i] + " ");
        }*/

    }

}
