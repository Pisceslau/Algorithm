package sort;

/**
 * Created by Lunar on 2016/1/20.
 * 快速排序
 */
public class Quick {
    public static void sort(int[] a) {
        //消除对输入的依赖
        sort(a, 0, a.length - 1);
    }

    private static void sort(int[] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(a, lo, hi);

        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    private static int partition(int[] a, int lo, int hi) {
        //将数组切分为a[lo..i-1],a[i],a[i+1..hi]
        int i = lo, j = hi + 1;
        int v = a[lo];
        while (true) {

                /*没意外左侧指针就一直右移，直到到达最右侧就跳出来
            * */
            //扫描左右检查扫描是否结束并交换元素
            while (a[++i] < v) {
                //左侧指针到达右侧
                if (i == hi)
                    break;
            }
            /*没什么意外右指针就左移，直到到达最左边，就跳出来*/
            while (v < a[--j]) {
                //右侧的指针到达左侧
                if (j == lo)
                    break;
            }


           /* 以上条件（左边值小于右边）之外的条件就是执行此交换操作的条件（意外）即为：
           左边的值大于右边了可以写while/if(a[i]>a[j]然后交换a[i],a[j]的值，更容易理解

           * */
             /*如果左边指针位置过了右边就跳出来这个while(true)说明相遇了，执行lo,j的交换（第二个交换）*/
            if (i >= j) {
                break;
            }
            //交换a[i],a[j]
            while (a[i] >=a[j]) {
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }
        //将v = a[j] 放入正确的位置
        int t = a[lo];
        a[lo] = a[j];
        a[j] = t;

        return j;//a[lo..j-1] <=a[j] <= a[j+1..h ]达成
    }

    public static void main(String[] args) {
        int[] array = {4, 5, 2, 6, 6, 3, 27, 6, 23, 86, 9,89,4,980,90};
        sort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }


}
