package Algorithm;

import java.util.Arrays;

/**
 * s
 * Created by E440 on 2016/1/18.
 */
public class BinarySearch {
    public static int rank(int key, int[] a) {
        //数组必须是有序的
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {

            int mid = lo + (hi - lo) / 2;
            if (key < a[mid])
                hi = mid - 1;
            else if (key > a[mid])
                lo = mid + 1;
            else return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] whiteList = StdIn.readAllInts();
        int[] a = {1, 4, 56, 4, 3, 6, 8, 2, 66, 45};
        Arrays.sort(whiteList);
        System.out.print(rank(6, a));
        //如果输入的不是空的话
        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            if (rank(key, whiteList) < 0) {
                System.out.println(key);
            }
        }

    }
}
