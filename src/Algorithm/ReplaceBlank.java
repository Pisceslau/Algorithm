package Algorithm;

/**
 * Created by Lunar on 2016/3/5.
 * 剑指Offer题目：将字符串中的空格替换为%20
 */
public class ReplaceBlank {
    public static String replaceBlank(char string[], int originalLength) {
        if (string == null || originalLength <= 0) return "";

        int numberOfBlank = 0;//字符串的空格数目
        //这里的长度是原始长度
        for (int i = 0; i < originalLength; i++) {
            numberOfBlank++;
        }

        //新的字符串长度为原字符串的长度+2*空格数目
        int newLength = originalLength + 2 * numberOfBlank;

        int indexOfOriginal = originalLength - 1;
        int indexOfNew = newLength - 1;
        while (indexOfOriginal >= 0 && indexOfNew > indexOfOriginal) {
            if (string[indexOfOriginal] == ' ') {
                string[indexOfNew--] = '0';
                string[indexOfNew--] = '2';
                string[indexOfNew--] = '%';
            } else {
                //复制字符串
                string[indexOfNew--] = string[indexOfOriginal];
            }
            --indexOfOriginal;
        }
        return new String(string);
    }

    public static void main(String[] args) {
        String s = "Liuwenyue is a good man!";
        char[] oldChars = s.toCharArray();
        char[] newChars = new char[100];
        for (int i = 0; i < oldChars.length; i++) {
            newChars[i] = oldChars[i];
        }
        //第二个参数需要以前的old长度
        System.out.println(replaceBlank(newChars, oldChars.length));
    }
}
