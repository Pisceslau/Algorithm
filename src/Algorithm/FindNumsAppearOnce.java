package Algorithm;

import java.util.Arrays;

/**
 * Created by Lunar on 2016/3/24.
 * 剑指Offer第四十题：数组中只出现一次的数字
 * 思路：（1）若只有一个数字出现一次，其他的数字出现二次，那么
 * 每个数异或最后剩下的就是只出现二次的数，因为相同的数异或后结果为0
 * （2）分组：根据最终异或的结果右数某位为1
 * 分为二组，只要是相同的数肯定分一组了
 * 然后每组分别异或求得最终的结果。
 */
public class FindNumsAppearOnce {
    //发现右数第数为1的第一个比特位的索引
    static int findFirstBitIs1(int num) {
        int indexBit = 0;
        int BITS = Integer.SIZE * 8;
        //当不为1继续右移动
        while ((num & 1) == 0 && (indexBit < BITS)) {
            num = num >> 1;
            indexBit++;
        }
        return indexBit;
    }

    //判断右边数第某位是不是1
    static boolean isBit1(int num, int indexBit) {
        num = num >> indexBit;
        return (num & 1) == 1;//那个数与1相与为1说明是1
    }

    //发现出现1次的二个数字
    static String findNumsAppearOnce(int data[]) {
        if (data == null || data.length < 0) return null;
        //异或结果的初始值设为0
        int resultExclusiveOR = 0;
        //进行异或运算得到最终的异或值
        for (int i = 0; i < data.length; i++) {
            resultExclusiveOR ^= data[i];
        }
        //根据这个异或的值进行分组，顺便求得每个组的只出现一次的数字
        int index = findFirstBitIs1(resultExclusiveOR);
        int[] result = new int[2];
        for (int i = 0; i < data.length; i++) {
            //如果原数组每一个数的倒数某几位是1的话,这些数字分为了一组，然后异或每一个数，得到最后结果
            // 数组默认初始值都为0的
            // 存入result数组里
            if (isBit1(data[i], index)) {
                result[0] ^= data[i];
            } else {
                result[1] ^= data[i];
            }
        }
        //把数组的值转为字符串输入
        return Arrays.toString(result);
    }

    public static void main(String[] args) {
        int[] a = {2, 3, 4, 6, 3, 2, 5, 5};
        System.out.println(findNumsAppearOnce(a));
    }

}
