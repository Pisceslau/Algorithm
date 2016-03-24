package Sort;

/**
 * Created by Lunar on 2016/3/13.
 * 排序算法：冒泡排序
 */
public class Bubble {
    //每趟个大元素沉入海底
    public static void bubbleSort(int[] a) {
        for (int i = 0; i < a.length-1; i++) {
            for (int j = 0; j < a.length-1-i; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {4, 5, 2, 6, 6, 3, 27, 6, 23, 86, 9};
        bubbleSort(a);
        for(int i =0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
    }
}
