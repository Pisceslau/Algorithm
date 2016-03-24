package Algorithm;

/**
 * Created by Lunar on 2016/3/24.
 * 剑指Offer第四十二题：翻转单词顺序VS左旋转字符串
 */
public class Reverse {
    //翻转字符串中的一段
    static void reverse(char[] chars, int begin, int end) {
        if (chars == null || begin > end) return;
        while (begin < end) {
            char temp = chars[begin];
            chars[begin] = chars[end];
            chars[end] = temp;
            begin++;
            end--;
        }
    }

    //翻转句子中的每个单词
    static String reverseSentence(String s) {
        char[] chars = s.toCharArray();
        if (chars == null) return null;
        int begin = 0;
        int end = chars.length - 1;
        //翻转整个句子
        reverse(chars, begin, end);
        //翻转句子中的每个单词
        int lengthOfWord = 0;//单词的长度

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                int right = i - 1;//单词末尾
                int left = right - lengthOfWord + 1;//单词开头
                //找到开头末尾则翻转这个单词
                reverse(chars, left, right);
                //重新把单词长度置0，计算下一个单词长度
                lengthOfWord = 0;
            } else {
                lengthOfWord++;
            }
        }
        return new String(chars);
    }

    //第二个算法：左旋转字符串
    public static void leftRotateString(char[] chars,int n) {
        if (chars != null) {
            int length = chars.length;
            reverse(chars, 0, length-1);//旋转整个“字符串”
            reverse(chars, 0,n-1);//旋转左字符串
            reverse(chars, n,length-1);//旋转右字符串
        }
    }
    public static void main(String[] args) {
        String s = "I am a student.";
        //第一个算法的测试
        System.out.println(reverseSentence(s));
        //第二个算法的测试
        String string = "Hello World";
        char[] chars = string.toCharArray();
        leftRotateString(chars, 5);
        System.out.println(chars);
    }
}
