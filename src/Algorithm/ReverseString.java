package Algorithm;

import java.util.Scanner;

import static java.lang.System.in;

/**
 * Created by Lunar on 2016/3/4.
 * 字符串的旋转：三步翻转法
 */
public class ReverseString {
    static void reverse(char[] s, int i, int j) {

      /*  while (i < j) {
            char c = s.charAt(i);
            s.charAt(i)=s.charAt(j);*/
        while (i < j) {
            char c = s[i];
            s[i++] = s[j];
            s[j--] = c;
        }


    }

    static void leftRotateString(char[] s, int n, int m) {
        m %= n;
        reverse(s, 0, m - 1);
        reverse(s, m, n - 1);
        reverse(s, 0, n - 1);

    }

    public static void main(String[] args) {
        do {
            System.out.println("请输入字符串：");
            Scanner scanner = new Scanner(in);
            String s = scanner.next();
            char[] chars;
            chars = s.toCharArray();
            leftRotateString(chars, s.length(), 3);
            for (int i = 0; i < s.length(); i++) {
                System.out.print(chars[i]);
            }

        } while (true);
    }
}


