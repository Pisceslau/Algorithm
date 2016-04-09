package CrackingTheCodingInterview;

/**
 * Created by Lunar on 2016/4/9.
 * 程序员面试金典1.1 确定字符串互异
 * 使用异或双重for循环。
 */
public class IsUniqueChars {
    public boolean checkDifferent(String str) {
        //使用异或
        if (str.length() > 256) return false;
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j < str.length(); j++) {
                if ((str.charAt(i) ^ str.charAt(j)) == 0)
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "liuweny";
        System.out.println(new IsUniqueChars().checkDifferent(s));
    }
}
