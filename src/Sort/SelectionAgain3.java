package Sort;

/**
 * Created by Lunar on 2016/3/13.
 * 默写选择排序3：逐渐选择剩余元素中的最小者
 */
public class SelectionAgain3 {
    public static void selectionSort(int a[]) {
        for (int i = 0;i<a.length;i++) {
            int min = i;//最下元素下标的初始值
            for (int j = i+1;j<a.length;j++) {
                if (a[j] < a[min]) {
                    min = j;//找到最小元素的下标
                }
                int temp = a[min];
                a[min] = a[i];
                a[i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {4, 5, 2, 6, 6, 3, 27, 6, 23, 86, 9};
        selectionSort(a);
        for(int i =0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
    }
}
