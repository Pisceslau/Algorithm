package Algorithm;

import java.util.TreeSet;

/**
 * Created by Lunar on 2016/3/20.
 * 剑指Offer第三十题：最小的k位数
 */
public class GetLeastNumbers {
    private static int partition(int[] a, int lo, int hi) {
        int v = a[lo];
        //二个指针
        int i = lo, j = hi + 1;
        while (true) {
            while (a[++i] < v) {
                if (i == hi) break;
            }
            while (a[--j] > v) {
                if (j == lo) break;
            }
            if (i >= j) {
                break;
            }
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

    //第一种方法：基于快速排序的partition函数
    static int[] getLeastOfNumbers(int[] input, int k) {
        int n = input.length;
        int[] output = new int[k];
        if (input == null || k > n || n <= 0 || k < 0) {
            return null;
        }
        int start = 0;
        int end = n - 1;
        int index = partition(input, start, end);
        while (index != k - 1) {
            if (index > k - 1) {
                end = index - 1;
                index = partition(input, start, end);
            } else {
                start = index + 1;
                index = partition(input, start, end);
            }
        }

        for (int i = 0; i < k; i++) {

            output[i] = input[i];
        }
        return output;
    }

    /*
     * 2. O(nlgk) 在遍历的过程中维护k个最小的数
	 * numbers 可以使基于流的 从而不必全部到达内存
	 */
    // TreeSet 基于 TreeMap 能保证key的有序性//没有重复元素
    public static TreeSet<Integer> getLeastNumbers2(int[] numbers, int k) {


        TreeSet<Integer> kLeast = new TreeSet<>();
        for (int i = 0; i < numbers.length; i++) {
            if (kLeast.size() < k)
                kLeast.add(numbers[i]);
            else {
                if (numbers[i] < kLeast.last()) {
                    kLeast.remove(kLeast.last());
                    kLeast.add(numbers[i]);
                }
            }
        }
        return kLeast;
    }
    //第一种方法有重复元素，第二种方法没有重复元素
    public static void main(String[] args) {
        int[] a = {4, 5, 1, 6, 2, 7, 3, 8,56,3,0};
        int[] bs = getLeastOfNumbers(a, 5);
        if (bs != null) {
            for (int b : bs) {
                System.out.print(b + " ");
            }
        }
        //第二种方法测试
        TreeSet<Integer> treeSet = getLeastNumbers2(a, 7);
        System.out.println(treeSet.toString());
    }
}
