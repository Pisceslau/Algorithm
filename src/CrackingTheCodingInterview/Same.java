package CrackingTheCodingInterview;

/**
 * Created by Lunar on 2016/4/10.
 * 程序员面试金典1.3：确定两串乱序同构
 * 哈希表思想：已通过牛客AC
 */
public class Same {
    public boolean checkSam(String stringA, String stringB) {
        // write code here
        //计算字符串A的每个字符出现的频率，频率为哈希表的值，字符为键
        if (stringA.length() != stringB.length()) return false;

        int[] letters = new int[256];
        for (int i = 0; i < stringA.length(); i++) {
            letters[stringA.charAt(i)]++;
        }

        for (int i = 0; i < stringB.length(); i++) {
            letters[stringB.charAt(i)]--;//在这里判断是不是都为0，会导致有的字符没用上
        }
        //检查每个频率最后是不是为0，都为0说明AB二个字符串字符都相同。
        for (int i = 0; i < letters.length; i++) {
            if (letters[i] != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String a = "liuwenyue";
        String b = "wenyueliu";
        System.out.println(new Same().checkSam(a, b));
    }
}