package Algorithm;

import java.util.HashMap;

/**
 * Created by Lunar on 2016/3/23.
 * 剑指Offer：第一个只出现一次的字符：
 * 思路：使用辅助空间的键索引计数法，计算每个字符频率，二次扫描获得频率为1的字符即可。
 */
public class FirstNotRepeatingChar {
    //自己构建Hash表
    public static char firstNotRepeatingChar(char[] chars) {
        if (chars == null) return '0';
        int tableSize = 256;
        //辅助数组
        char[] help = new char[tableSize];
        for (int i = 0; i < chars.length; i++) {
            help[chars[i]]++;
        }
        for (int i = 0; i < help.length; i++) {
            if (help[i] == 1)
                return (char) i;
        }
        return '0';
    }

    //使用Java内置的哈希表
    public static char firstNotRepeatingCharByHashMap(char[] chars) {

        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            //如果已经有这个key，也就是字符了,修改频率加1
            if (hashMap.containsKey(chars[i])) {
                int value = hashMap.get(chars[i]);//得到其值
                hashMap.remove(chars[i]);
                hashMap.put(chars[i], value + 1);
            } else {
                hashMap.put(chars[i], 1);
            }
        }
        //第二次循环得到第一次频率为1的字符
        for (int i = 0; i < chars.length; i++) {
            if (hashMap.get(chars[i]) == 1) return chars[i];
        }
        return '0';
    }

    public static void main(String[] args) {
        String s = "abaccdeeffbzd";
        char[] chars = s.toCharArray();
        System.out.println(firstNotRepeatingChar(chars));
        System.out.println(firstNotRepeatingCharByHashMap(chars));

    }
}
