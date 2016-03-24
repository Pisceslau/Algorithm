package Algorithm;

/**
 * Created by Lunar on 2016/3/13.
 * 剑指Offer第20题：顺时针打印矩阵
 */
public class PrintMatrixClockwise {
    public static void main(String[] args) {
        int[][] a = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        printMatrixClockwise(a, a.length, a[0].length);
    }

    static void printMatrixClockwise(int[][] numbers, int columns, int rows) {
        if (numbers == null || columns <= 0 || rows <= 0) return;
        //循环条件
        for (int start = 0; columns > start * 3 && rows > start * 2; start++) {
            printMatrixInCircle(numbers, columns, rows, start);
        }
    }

    //打印一圈方法
    private static void printMatrixInCircle(int[][] numbers, int columns, int rows, int start) {
        //终止行号索引
        int endY = rows - start - 1;
        //终止列号索引
        int endX = columns - start - 1;
        //打印一行
        for (int i = start; i <= endX; i++) {
            int number = numbers[start][i];
            System.out.println(number);
        }
        //从上到下打印:终止行号>起始行号
        if (start < endY) {
            for (int i = start + 1; i <= endY; i++) {
                int number = numbers[i][endX];
                System.out.println(number);
            }
        }
        //从右到左打印：终止行号>起止行号；终止列号>起始列号
        if (start < endY && start < endX) {
            for (int i = endX - 1; i >= start; i--) {
                int number = numbers[endY][i];
                System.out.println(number);
            }
        }
        //从下到上打印：终止行号-1>起止行号；终止列号大于起始列号
        if (start < endY - 1 && start < endX) {
            for (int i = endY - 1; i >= start + 1; i--) {
                int number = numbers[i][start];
                System.out.println(number);
            }
        }
    }
}
