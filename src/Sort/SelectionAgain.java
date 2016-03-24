package sort;

/**
 * Created by Lunar on 2016/1/18.
 * 默写选择排序
 * 运行时间与输入无关
 * 数据移动是最少的
 */
public class SelectionAgain {
    //排序的方法：
    public static void sort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int min = i;//最小下标为i
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
                //与 最小 的交换元素
            }
            int t = a[i];
            a[i] = a[min];
            a[min] = t;
        }
    }

    //测试
    public static void main(String[] args) {
        int[] array = {4, 5, 2, 6, 6, 3, 27, 6, 23, 86, 9};
        sort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

}
