package Algorithm;

import java.util.Scanner;

import static java.lang.System.in;

/**
 * Created by Lunar on 2016/3/4.
 * 回文判断
 */
public class Palindrom {
    static boolean isPalindrome(char[] s, int n) {
        //非法输入
        if (s == null || n < 1) {
            return false;
        }
        int front, back;
        front = 0;
        back = s.length - 1;
        while (front < back) {
            if (s[front] != s[back]) {
                return false;
            }
            ++front;
            --back;
        }
        return true;
    }

    public static void main(String[] args) {
            do {
                System.out.println("请输入字符串：");
                Scanner scanner = new Scanner(in);
                String s = scanner.next();
                char[] chars;
                chars = s.toCharArray();
                System.out.print(isPalindrome(chars, chars.length));
            }while (true);
    }
}
