package Algorithm;

/**
 * Created by Lunar on 2016/3/5.
 * 二维数组
 */
public class Matrix2D {
    /*静态初始化一个静态数组*/
    static int[][] matrix = {
            {1, 2, 8, 9},
            {2, 4, 9, 12},
            {4, 7, 10, 13},
            {6, 8, 11, 15}
    };

    public static void main(String[] args) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {

                  System.out.print(matrix[i][j]+" ");
            }
        }

    }
}
