package Algorithm;

/**
 * Created by Lunar on 2016/3/28.
 * 剑指Offer第四十一题：和为s的两个数字VS和为s的连续正数序列
 * <p>
 * 题目一：输入一个递增排序的数组和一个数字s，在数组中查找两个数，
 * 使得它们的和正好是s,如果有多对数字的和等于s输出任意一对即可。
 * 思路：O（n^2）固定一个数字，依次判断其余数字与其和是不是为s
 * O(n)：两个指针，一个在前，一个在后，计算和，若和小于s则，后移动前面（较小的数的）指针，若和大于s,则前移动后面数字指针
 * 注意！：找到数要break跳出循环防止无限循环！
 * <p>
 * 题目二：输入一个正数，打印出所有和为s的连续正数序列（至少含有两个数）。例如输入15，由于1+2+3+4+5+6=7+8=15
 * 所以结果打印出3个连续序列1~5、4~6和7~8。
 * <p>
 * 思路：
 */
public class FindNumbersWithSum {
    /**
     * 题目一：和为s的两个数字
     *
     * @param data 输入的有序数组
     * @param sum  期待的和
     * @return 是否找到和为s的数
     */
    public static boolean findNumbersWithSum(int data[], int sum) {
        if (data == null) return false;
        int length = data.length;
        if (length < 1) return false;
        boolean found = false;
        int left = 0, right = length - 1;

        while (left < right) {
            int curSum = data[left] + data[right];
            //此时和小于期待和
            if (curSum < sum) left++;
                //此时和大于期待和
            else if (curSum > sum) right--;
                //此时和相等期待和
            else {
                found = true;
                System.out.println(data[left] + "," + data[right]);
                //break跳出while循环，放置无限输出
                break;
            }

        }
        return found;

    }

    public static void main(String[] args) {
        //题目一测试
        int[] a = {1, 2, 4, 7, 11, 15};
        System.out.println(findNumbersWithSum(a, 15));
        //题目二测试
        findContinuousSequence(15);

    }

    /**
     * 题目二：和为s的连续正数序列
     *
     * @param sum 期待和
     */
    public static void findContinuousSequence(int sum) {
        if (sum < 3) return;
        int small = 1, big = 2;
        int curSum = small + big;
        int middle = (1 + sum) / 2;
        while (small < middle) {
            if (curSum == sum) printContinuousSequence(small, big);
            while (curSum > sum && small < middle) {
                //现在的和大于期待和，则把小的那个数减去，同时，small增加
                curSum -= small;
                small++;
                if (curSum == sum) printContinuousSequence(small, big);
            }
            //while外其他就是小于期待和的情况了
            big++;
            curSum += big;
        }
    }

    /**
     * 输出这个连续数列。
     *
     * @param small 前面小数
     * @param big   后面大数
     */
    static void printContinuousSequence(int small, int big) {
        for (int i = small; i <= big; i++)
            System.out.print(i + ", ");
        System.out.println();
    }
}
