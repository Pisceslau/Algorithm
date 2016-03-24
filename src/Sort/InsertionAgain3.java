package Sort;

/**
 * Created by Lunar on 2016/3/13.
 * 默写插入排序
 */
public class InsertionAgain3 {
    public static void insertionAgain(int[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0; j--) {
                if (a[j] < a[j - 1]) {
                    int temp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {4, 5, 2, 6, 6, 3, 27, 6, 23, 86, 9};
        insertionAgain(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}

