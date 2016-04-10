package CrackingTheCodingInterview;

/**
 * Created by Lunar on 2016/4/10.
 * 程序员面试金典：1.4：字符串空格替换为%20
 */
//剑指Offer的思路
public class Replacement {
    public String replaceSpace(String string, int originalLength) {
        if (string == null || originalLength <= 0) return null;

        int numberOfBlank = 0;//字符串的空格数目
        //这里的长度是原始长度
        for (int i = 0; i < originalLength; i++) {
            if (string.charAt(i) == ' ')
                numberOfBlank++;
        }

        //新的字符串长度为原字符串的长度+2*空格数目
        int newLength = originalLength + 2 * numberOfBlank;
        char[] temp = new char[newLength];
        for (int i = 0; i < originalLength; i++) {
            temp[i] = string.charAt(i);
        }
        int indexOfOriginal = originalLength - 1;
        int indexOfNew = newLength - 1;
        while (indexOfOriginal >= 0 && indexOfNew > indexOfOriginal) {
            if (temp[indexOfOriginal] == ' ') {
                temp[indexOfNew--] = '0';
                temp[indexOfNew--] = '2';
                temp[indexOfNew--] = '%';
            } else {
                //复制字符串
                temp[indexOfNew--] = temp[indexOfOriginal];
            }
            --indexOfOriginal;
        }
        return new String(temp);
    }
}