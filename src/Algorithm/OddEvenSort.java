package Algorithm;

/**
 * Created by Lunar on 2016/3/4.
 * 奇偶数排序：快速排序的变形
 */
public class OddEvenSort {
    public static void main(String[] args) {
        int[] a = {4, 5, 56, 56, 3, 7, 34};
        partition(a);
        for (int i : a) {
            System.out.print(i+" ");
        }
    }

    static boolean isOddNumber(int number) {
        //位运算判断是否为奇数，因为奇数二进制末尾为1
        return (number & 1) == 1;
    }

    static void swap(int[] a, int m, int n) {
        int temp = a[m];
        a[m] = a[n];
        a[n] = temp;
    }

    public static void partition(int[] a) {
        if (a == null || a.length == 0) return;
        //首尾指针下标
        int i = 0;
        int j = a.length - 1;

        while (i < j ) {
            if (isOddNumber(a[i])) i++;
            else if (!isOddNumber(a[j])) j--;
            else {
                swap(a, i, j);
            }
        }
    }
}
