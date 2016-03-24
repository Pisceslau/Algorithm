package sort;

/**
 * Created by Lunar on 2016/1/18.
 * 默写插入排序
 * 插入排序改进：待续
 */
public class InsertionAgain {
    public static void sort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i;
                 j > 0; j--) {
                if (a[j] < a[j - 1]) {
                    //插入排序是与相邻的交换，选择排序是与最小的交换
                    int t = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = t;
                }

            }
        }

    }

    //测试
    public static void main(String[] args) {
        int[] a = {1, 3, 5, 3, 5, 567, 78, 5, 8, 7, 3, 8};
        sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }

    }
}
