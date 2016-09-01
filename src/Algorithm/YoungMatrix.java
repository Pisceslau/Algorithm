package Algorithm;

/**
 * Created by Lunar on 2016/3/5.
 * 杨氏矩阵查找：行列递增的矩阵的查找
 * 二维数组的行数和列数
 * array.length 就是行数
 * array [0].length 就是列数
 */
public class YoungMatrix {
    public static final int ROW = 4;
    public static final int COL = 4;

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}
        };
        System.out.print(youngMatrix(matrix, 19));
    }

    static boolean youngMatrix(int array[][], int target) {

        if (array == null) return false;
        boolean find = false;
        //二维数组的行数
        int rows = array.length;
        //二维数组的列数
        int columns = array[0].length;
        //初始位置：右上角
        if (rows > 0 && columns > 0) {
            int i = 0;
            int j = columns - 1;

            while (j >= 0 && i < rows) {

                if (array[i][j] == target) {
                    find = true;
                    break;

                } else if (array[i][j] > target) {
                    --j;
                } else {
                    ++i;
                }
            }
        }

        return find;
    }

}