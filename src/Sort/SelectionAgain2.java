package sort;

/**
 * Created by Lunar on 2016/1/19.
 * 默写选择排序
 */
public class SelectionAgain2 {
    public static void sort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }

            }
            int t = a[i];
            a[i] = a[min];
            a[min] = t;

        }
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 5, 3, 5, 567, 78, 5, 8, 7, 3, 8};
        sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
