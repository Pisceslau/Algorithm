package Search;

/**
 * Created by Lunar on 2016/1/26.
 *
 */
public class BinarySearchTest {

    //找寻三
    public static int rank(int key, int[] a, int lo, int hi) {
        if (hi < lo) return lo;
        int mid = lo + (hi - lo) / 2;
        if (key < a[mid]) {
            return rank(key, a, lo, mid - 1);
        } else if (key > a[mid]) {
            return rank(key, a, mid + 1, hi);
        } else {
            return mid;

        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 45, 6, 66, 7, 5};
        int result = rank(66, array, 0, array.length - 1);
        System.out.println(result);
    }
}
