package CrackingTheCodingInterview;

/**
 * Created by Lunar on 2016/4/10.
 * 程序员面试金典：1.5 字符串压缩
 */
public class Zipper {
    public static void main(String[] args) {
        String s = "aabcccccaaa";
        String s2 = "abc";
        System.out.println(new Zipper().zipString(s));
    }

    int countCompression(String string) {
        if (string == null || string.isEmpty()) {
            return 0;
        }
        char last = string.charAt(0);
        int size = 0;
        int count = 1;
        for (int i = 1; i < string.length(); i++) {
            if (string.charAt(i) == last) {
                count++;
            } else {
                last = string.charAt(i);
                size += 1 + String.valueOf(count).length();
                count = 1;
            }
        }
        size += 1 + String.valueOf(count).length();
        return size;
    }

    public String zipString(String iniString) {
        int size = countCompression(iniString);
        if (size >= iniString.length()) {
            return iniString;
        }
        char[] newChars = new char[size];
        int times = 1;//每个字符串的频率
        char c = iniString.charAt(0);
        int j = 0;
        for (int i = 1; i < iniString.length(); i++) {

            if (iniString.charAt(i) == c) {
                times++;
            } else {
                //新数组里面
                j = setChar(newChars, times, c, j);
                //times和c恢复初始值
                c = iniString.charAt(i);
                times = 1;
            }
        }
        /*因为最后一组重复之后，后面没有不同的字符了，所以就无法到达else语句，所以在此要
        把最后一组字符放入
        * */
        j = setChar(newChars, times, c, j);
        return String.valueOf(newChars);
    }

    private int setChar(char[] newChars, int times, char c, int j) {
        newChars[j] = c;
        j++;//必须使用单独的++操作，而不是下面的newChar[j+1],因为只是移动指针，
        //但是i还是原来值！！
        char[] temp = String.valueOf(times).toCharArray();//可能出现多个位的同样字符，所以字符就多了
        for (char x : temp) {
            newChars[j] = x;
            j++;
        }
        return j;
    }
}
