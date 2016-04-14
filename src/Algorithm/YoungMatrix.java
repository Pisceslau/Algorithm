package Algorithm;

/**
 * Created by Lunar on 2016/3/5.
 * 杨氏矩阵查找：行列递增的矩阵的查找
 * 二维数组的行数和列数
 * array.length 就是行数
 array [0].length 就是列数
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
        System.out.print(youngMatrix(matrix, 6));
    }

    static boolean youngMatrix(int a[][], int searchKey) {
        int i = 0, j = COL - 1;//最右上角的元素
        int var = a[i][j];

        while (true) {
            if (var == searchKey) return true;
            else if (var > searchKey && j > 0) var = a[i][--j];//左边移动
            else if (var < searchKey && i < ROW - 1) var = a[++i][j];
            else {
                return false;
            }
        }
    }


}