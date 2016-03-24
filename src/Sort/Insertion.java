package sort;

/**
 * Created by Lunar on 2016/1/18.
 * 插入排序
 * 时间取决于输入中元素的初始顺序
 * 接近有序的数组使用插入排序比较好
 * <p>
 * 思想：对左侧的元素只要更左边的元素大于它就交换，保证了左边始终是从左到右是有序的
 * 这样，下标到最右边就整体就有序了
 * <p>
 * 插入排序快于选择排序
 */
public class Insertion {
    //将a[i]到i之前,所以初始值为1
    public static void sort(int[] a) {
        for (int i = 1; i < a.length; i++) {

            for (int j = i; j > 0; j--) {

                if (a[j] < a[j - 1]) {
                    int t = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = t;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 4, 3, 5, 5, 45, 76, 76, 3, 4, 45, 78, 98};
        sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
