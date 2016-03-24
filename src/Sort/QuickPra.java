package Sort;

/**
 * Created by Lunar on 2016/3/14.
 * 快速排序练习
 */
public class QuickPra {
    //快速排序的切分过程
    public static int partition(int[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;//左右指针
        int v = a[lo];//切分那个值

        while (true) {
            while (a[++i]<v)if (i==hi)break;
            while (a[--j]>v)if (j==lo)break;
            //如果发现i的值大于j的值则交换
            if (i>=j) break;//相遇了则跳出外层while,交换首元素和i最右侧的部分的元素
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;


        }
        int temp = a[j];
        a[j] = a[lo];
        a[lo] = temp;
        return j;
    }

    public static void sort(int[] a) {
        sort(a,0,a.length-1);
    }

    private static void sort(int[] a, int lo, int hi) {
        if (hi<=lo)return;
        int j = partition(a, lo, hi);
        sort(a,lo,j-1);
        sort(a,j+1,hi);
    } public static void main(String[] args) {
        int[] a = {4, 5, 2, 6, 6, 3, 27, 6, 23, 86, 9};
        sort(a);
        for(int i =0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
    }


}
