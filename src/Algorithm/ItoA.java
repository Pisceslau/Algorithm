package Algorithm;

/**
 * Created by Lunar on 2016/3/5.
 * 把字符串中的数字变为整数 StrToInt
 */
public class ItoA {
    //设置个变量用来检测是不是非法
    boolean isValid = true;

    private static long stringToIntCore(String str, int begin, boolean isNegative) {
        int flag = isNegative ? -1 : 1;//设置flag用来输出正确的负数整数
        int index = begin;
        long sum = 0;
        for (int i = index; i < str.length(); i++) {
            //判断字符是不是0-9
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                sum = sum * 10 + flag * (str.charAt(index) - '0');
            } else {
                return 0;//如果输入的数字不是0-9中的数字则返回0
            }
        }
        //对和考虑越界溢出情况
        if ((isNegative && (sum < Integer.MIN_VALUE)) || !isNegative && (sum > Integer.MAX_VALUE)) {
            return 0;
        }
        return sum;
    }

    public int stringToInt(String str) {
        //设置变量看是不是负数
        boolean isNegative = false;
        //和
        long sum = 0;
        int begin = 0;//第一个字符的下标
        //输入检查"" 和 空指针
        if (str != null && !str.equals("")) {
            //检查第一个字符是不是正好符号的问题
            char firstChar = str.charAt(begin);
            if (firstChar == '+' || firstChar == '-') {
                begin = 1;
                if (firstChar == '-') {
                    isNegative = false;
                }
            }
            sum = stringToIntCore(str, begin, isNegative);
        }
        isValid = false;
        return (int) sum;
    }
}
