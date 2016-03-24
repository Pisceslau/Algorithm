package Algorithm;

import java.util.Arrays;

/**
 * Created by Lunar on 2016/3/5.
 * 二分查找是建立在有序数组的基础之上！！！！！！
 */
public class BinaryFind {

    public static int indexOf(int[] a, int key) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            // Key is in a[lo..hi] or not present.
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }

    public static int binarySearch(int[] a,int k) {
        return binarySearch(a,k,0,a.length-1);
    }
    public static int binarySearch(int[]a,int k, int lo,int hi) {

        if (hi < lo) {
            return lo;
        }
        int mid = lo + (hi-lo)/2;
        if (a[mid]>k)return binarySearch(a,k,lo,mid-1);
        else if (a[mid]<k)return binarySearch(a,k,mid+1,hi);
        else
            return mid;
    }

    public static void main(String[] args) {
        int[] a = {1, 4, 56, 4, 3, 7, 8, 2, 66, 45};
        Arrays.sort(a);
        System.out.print(indexOf(a, 7));
        System.out.print(binarySearch(a,7));

    }
}
