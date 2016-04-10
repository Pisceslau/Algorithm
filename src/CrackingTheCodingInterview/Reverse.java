package CrackingTheCodingInterview;

/**
 * Created by Lunar on 2016/4/10.
 * 程序员面试金典：1.2翻转字符串，通过牛客AC
 */
public class Reverse {
    public String reverseString(String iniString) {
        // write code here
        if (iniString == null) return null;
        char[] chars = iniString.toCharArray();
        int begin = 0;
        int end = iniString.length() - 1;
        while (begin < end) {
            char temp = chars[begin];
            chars[begin] = chars[end];
            chars[end] = temp;

            begin++;
            end--;
        }
        return new String(chars);
    }
}
