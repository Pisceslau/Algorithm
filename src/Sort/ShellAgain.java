package Sort;

/**
 * Created by Lunar on 2016/3/13.
 * 希尔排序ShellSort 复习
 */
public class ShellAgain {
    public static void shellSort(int a[]) {
        int h = 1;
        while (h < a.length / 3) h = 3 * h + 1;//步长选择

        while (h >= 1) {
            for (int i = h; i < a.length; i++) {
                for (int j = i; j >= h; j -= h) {
                    if (a[j] < a[j - h]) {
                        int temp = a[j];
                        a[j] = a[j - h];
                        a[j - h] = temp;
                    }
                }
            }
            h /= 3;
        }

    }

    public static void main(String[] args) {
        int[] a = {1, 3, 5, 3, 5, 567, 78, 5, 8, 87, 45, 33, 7, 3, 8, 76, 90, 45, 67, 34, 78, 67};
        shellSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }

    }
}


