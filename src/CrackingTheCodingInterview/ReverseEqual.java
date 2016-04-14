package CrackingTheCodingInterview;

/**
 * Created by Lunar on 2016/4/10.
 * 程序员面试金典1.8：判断两个字符串是不是旋转而成:
 * 思路：s2是s1s1的子串
 */
public class ReverseEqual {
    public static void main(String[] args) {
        System.out.print(new ReverseEqual().checkReverseEqual("waterBottle", "erBottlewat"));
    }

    public boolean checkReverseEqual(String s1, String s2) {
        //检查s1,s2是否长度相同，而且不为空
        int len = s1.length();
        if (len == s2.length() && len > 0) {
            //拼接s1s1
            String s1s1 = s1 + s1;
            return s1s1.contains(s2);
        }
        return false;
    }
}
