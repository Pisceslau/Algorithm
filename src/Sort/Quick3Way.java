package Sort;

/**
 * Created by Lunar on 2016/1/22.
 * 快速排序三向切分
 */
public class Quick3Way {
    public static void sort(int[] a) {
        sort(a, 0, a.length - 1);
    }

    private static void sort(int[] a, int lo, int hi) {
        if (hi <= lo) return;
        int lt = lo, i = lo + 1, gt = hi;
        int v = a[lo];
        while (i <= gt) {
            if (a[i] < v) exch(a, lt++, i++);
            else if (a[i] > v) exch(a, i, gt--);
            else i++;
        }
        sort(a, lo, lt - 1);
        sort(a, gt + 1, hi);
    }

    public static void exch(int[] a, int m, int n) {
        int t = a[m];
        a[m] = a[n];
        a[n] = t;

    }

    public static void main(String[] args) {
        int[] a = {4, 5, 2, 6, 6, 3, 27, 6, 23, 86, 9};
        sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
