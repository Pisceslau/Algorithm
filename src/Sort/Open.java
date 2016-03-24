package Sort;

/**
 * Created by E440 on 2016/1/18.
 */
public class Open {
    //排序算法类模板
    //v比w小
    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static boolean less(int v, int w) {
        if (v < w) return true;
        return false;

    }


    //交换数组a中下标为i,j的值

    public static void exch(Comparable[] a, int i, int j) {
        //t为临时变量
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;

    }


    public static void exch(int[] a, int i, int j) {
        //t为临时变量
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
    //显示

    public static void show(Comparable[] a)
    {
        //在单行中打印数组
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }
    public static void  show(int[] a) {
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }

    //测试数组元素是否有序
    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++)
            //如果后面比前面小的话说明没有顺序
            if (less(a[i], a[i - 1])) return false;
        return true;
    }
    public static boolean isSorted(int[] a) {
        for (int i = 1; i < a.length; i++)
            //如果后面比前面小的话说明没有顺序
            if (less(a[i], a[i - 1])) return false;
        return true;
    }
}
