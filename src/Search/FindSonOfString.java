package Search;

/**
 * Created by Lunar on 2016/2/12.
 * 暴力字符串查找算法及其改进
 */
public class FindSonOfString {
    //原始版本
    public static int search(String pat, String txt) {
        int M = pat.length();
        int N = txt.length();
        for (int i = 0; i <= N - M; i++) {
            int j;
            for (j = 0; j < M; j++)
                if (txt.charAt(i + j) != pat.charAt(j))
                    break;
            if (j == M) return i; //找到匹配 i为模式首出现的下标

        }
        return N; //未找到匹配
    }

    //另外一种方法
    public static int searchChange(String pat, String txt) {
        int j, M = pat.length();
        int i, N = txt.length();

        for (i = 0, j = 0; i < N && j < M; i++) {
            if (txt.charAt(i) == pat.charAt(j)) j++;
            else {
                i -= j;
                j = 0;
            }

        }
        if (j == M) return i - M; //找到匹配
        else return M;       //未找到匹配
    }

    //主方法
    public static void main(String[] args) {
        String text = "Liuwenyue like Chinese people!";
        String pattern = "Chinese";
        System.out.print(search(pattern, text));
    }
}
