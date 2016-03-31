package Algorithm;

/**
 * Created by Lunar on 2016/3/31.
 * 剑指Offer第五十四题：表示数值的字符串。
 */
public class IsNumeric {
    static boolean isNumeric(String string) {
        if (string == null) return false;
        int index = 0;//移动的下标
        //检查正负号
        boolean numeric = true;
        int length = string.length();
        if (string.charAt(index) == '+' || string.charAt(index) == '-')
            index++;
        index = scanDigits(string, index);
        //如果还没到达字符串的末尾
        if (index < length) {
            //for floats
            if (string.charAt(index) == '.') {
                index++;
                index = scanDigits(string, index);
                if (string.charAt(index) == 'e' || string.charAt(index) == 'E')
                    numeric = isExponential(string, index);
            }
            //for integers

            else if (string.charAt(index) == 'e' || string.charAt(index) == 'E') {
                numeric = isExponential(string, index);
            } else numeric = false;
        }
        return numeric && index >= length;//因为最后的结果使和index==length与，所以中间不必再if到没到末尾。
    }

    //检查字符串0到9的数位
    static int scanDigits(String string, int index) {
        while (index < string.length() && string.charAt(index) >= '0' && string.charAt(index) <= '9')
            index++;
        return index;//因为Java按照值传递，原始的int不受影响，所以返回它更改相应的原来的值。
    }

    //检查匹配科学计数法表示的数值的结尾部分
    static boolean isExponential(String string, int index) {
        int length = string.length();
        if (index >= string.length() || (string.charAt(index) != 'e' && string.charAt(index) != 'E')) {
            return false;
        }
        //本索引数字等于E或e则移动到下一位。
        index++;

        if (string.charAt(index) == '+' || string.charAt(index) == '-') index++;
        // 到达字符串的末尾，就返回false，5E+的情况
        if (index == length) return false;

        index = scanDigits(string, index);
        return index == length;
    }

    public static void main(String[] args) {
        String[] numbers = {"+100", "5e2", "-123", "3.1416", "-1E-16", "12e", "1a3.14", "1.2.3", "12e+5.4", "+-5"};
        for (String s : numbers) {
            System.out.println(isNumeric(s));
        }
    }
}
