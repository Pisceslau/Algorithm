package sort;

/**
 * Created by Lunar on 2016/1/18.
 * <p>
 * 希尔排序
 * <p>
 * 思想：使数组中任意间隔为h的元素都是有序的
 * 这样的数组为h有序数组，换句话说，一个h有序数组
 * 就是h个互相独立的有序数组编织在一起组成的数组
 * 用插入排序将h个有序数组独立地排序，每个数组中，每个元素交换到
 * 比它大的元素之前去（即把比它大的元素向右移动一格）
 * 即每个数组是插入排序并增量为h
 * （类似于插入排序但使用不同增量（h）的过程）
 * 缩小增量排序
 * 希尔排序的外循环无论是i++还是i+=h,结果一样，推荐后者
 * <p>
 * <p>
 * 希尔排序可用于大型数组，数组越大优势越大，比插入、选择快得多。
 */
public class Shell {
    public static void sort(int[] a) {
        //将a[]按升序排列
        int h = 1;//设置增量为1
        while (h < a.length / 3) h = 3 * h + 1;//如果h小于数组长度的1/3，则增量h设置为3h+1
        while (h >= 1) {
            //将数组变为h有序，i初始值为h(类似于插入排序初始值为1)
            for (int i = h; i < a.length; i++) {
                //将a[i]插入到a[i-h],a[i-2h],a[i-3h]...之中
                for (int j = i; j >= h; j -= h) {
                    if (a[j] < a[j - h]) {
                        int t = a[j];
                        a[j] = a[j - h];
                        a[j - h] = t;
                    }
                }

            }//外层for结束

            h = h / 3;//增量缩小为原来的1/3
        }
    }

    //测试
    public static void main(String[] args) {
        int[] a = {1, 3, 5, 3, 5, 567, 78, 5, 8,87,45,33, 7, 3, 8, 76, 90, 45, 67, 34, 78, 67};
        sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }

    }
}
