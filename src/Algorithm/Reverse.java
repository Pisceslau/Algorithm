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
    static String reverseSentence(String str) {
        if (str == null || str.length() <= 0) return "";

        char[] chars = str.toCharArray();
        int length = chars.length;
        //翻转整个句子I ma a .tneduts

        reverse(chars, 0, length - 1);
        int start = 0;
        int end = 0;
        while (start < length) {
            //如果第一个字符就是空格的话,移动二个下标
            if (chars[start] == ' ') {
                start++;
                end++;
            }
            //如果end为字符串的长度即为整个字符串后面（不严谨的说法）或者有空格的话
            else if (end == length || chars[end] == ' ') {
                reverse(chars, start, end - 1);//翻转这个单词，end - 1为end-1后的值，但是end本身还是5
                end++;//单独一句无所谓最终end仍然加一，变为第二个单词的开始位置
                start = end;//start,end 位置又相同了，于是第三个else 语句执行。

            } else {
                //start不动，end直到空格为止。跑到上一个else if 语句
                end++;
            }
        }
        return new String(chars);
    }

    //第二个算法：左旋转字符串
    public static void leftRotateString(char[] chars, int n) {
        if (chars != null) {
            int length = chars.length;
            reverse(chars, 0, length - 1);//旋转整个“字符串”
            reverse(chars, 0, n - 1);//旋转左字符串
            reverse(chars, n, length - 1);//旋转右字符串
        }
    }

    public static void main(String[] args) {
        /*int a = 5;

        System.out.println(a-1);
        System.out.println(a);*/
        String s4 = "I come from China.";
        String s = "student. a am I";
        String s2 = "Hello! World";
        String s3 = "Wonderful!";
        //第一个算法的测试
        System.out.println(reverseSentence(s4));
        System.out.println(reverseSentence(s));
        System.out.println(reverseSentence(s2));
        System.out.println(reverseSentence(s3));
        //第二个算法的测试
        String string = "Hello World";
        char[] chars = string.toCharArray();
        leftRotateString(chars, 5);
        System.out.println(chars);
    }
}
