package sort;

import Sort.Open;

/**
 * Created by Lunar on 2016/1/18.
 * 选择排序
 */
public class Selection {
    public static void sort(int[] a) {
        //将a[]按升序排列
        for (int i = 0; i < a.length; i++) {
            //将a[i]和a[i+1..N]中最小元素进行交换
            int min = i;//最小元素的索引
            for (int j = i + 1; j < a.length; j++) {
                if (Open.less(a[j], a[min]))
                    min = j;
            }
            //交换
            Open.exch(a, i, min);

        }


    }


}
