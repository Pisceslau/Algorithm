package Search;

/**
 * Created by Lunar on 2016/2/12.
 * 默写暴力子字符串未优化版
 */
public class FindSonOfStringAgain {
    public static int search(String pat, String txt) {
        int M = pat.length();// 模式的长度
        int N = txt.length();// 文本的长度
        //为什么是N-M? 因为模式最多在文本最右侧，再进一步移动则肯定小于模式大小了所以绝不可能在N-M到N之间匹配
        for (int i = 0; i <= N - M; i++) {
            int j;
            for (j = 0; j < M; j++) {
                if (txt.charAt(i + j) != pat.charAt(j)) break;
            }
            //i 代表了几次没有成功找到模式的首字母，也代表找到首字母时候的下标，那么j由0到1..M,i+j则匹配了模式
            if (j == M) return i;
        }
        return N;//未匹配返回文本的长度
    }
    public static void main(String[] args){
        String pattern = "Python";
        String text = "Life is Short, I Write Python !";
        System.out.print(search(pattern, text));
    }
}
