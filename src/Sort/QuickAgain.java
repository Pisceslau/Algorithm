package Sort;

/**
 * Created by Lunar on 2016/1/20.
 * 默写快速排序
 */
public class QuickAgain {
    public static void sort(int[] a) {
        //有一个处理数组让他混乱无序的操作，暂时省略
        sort(a, 0, a.length - 1);

    }

    public static void sort(int[] a, int lo, int hi) {
        //根据返回的切分值递归使用sort
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    public static int partition(int[] a, int lo, int hi) {
        //二个指针
        int i = lo, j = hi + 1;
        //最低元素的值(初始切分值)
        int v = a[lo];
        while (true) {

            while (a[++i] < v) {
                //如果i到达最右边跳出此while
                if (i == hi) break;
            }

            while (a[--j] > v) {
                //如果右侧指针到达最左侧了，跳出此while
                if (j == lo) break;
            }
            //如果二个指针相遇了跳出整个大的while循环，执行最终的和初始切分值的交换动作

            if (i >= j) break;

            //当左侧元素大于右侧元素则交换
            int t = a[i];
            a[i] = a[j];
            a[j] = t;

        }
        //a[j]和初始切分值交换并返回j（下标）
        int t = a[lo];
        a[lo] = a[j];
        a[j] = t;
        return j;
    }

    public static void main(String[] args) {
        int[] array = {4, 5, 2, 6, 6, 3, 28, 6, 23, 86, 9};
        int[] b = {1};
        sort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

    }

}
