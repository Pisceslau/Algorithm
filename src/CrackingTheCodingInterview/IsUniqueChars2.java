package CrackingTheCodingInterview;

/**
 * Created by Lunar on 2016/4/9.
 * 程序员面试金典：1.1
 * 实现一个算法，确定一个字符串的所有字符是否都 全都不同，假如不使用额外的数据结构又该如何处理？
 * 解法1：键值对：键为每个字符的ASCII码，值为布尔值
 */
public class IsUniqueChars2 {
    public boolean isUniqueChars(String str) {
        if (str.length() > 256) return false;

        boolean[] char_set = new boolean[256];
        for (int i = 0; i < str.length(); i++) {
            int value = str.charAt(i);
            //如果这个字符是存在的话
            if (char_set[value]) {
                return false;
            }
            char_set[value] = true;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "Cracking The Coding Interview";
        System.out.println(new IsUniqueChars2().isUniqueChars(s));
    }
}
