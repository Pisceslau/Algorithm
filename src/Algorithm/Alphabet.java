package Algorithm;

import java.lang.Math;

public class Alphabet {
    String s;


    //根据s中的字符创建一张新的字母表
    public Alphabet(String s) {
        this.s = s;
    }

    //获取字母表中索引位置的字符
    char toChar(int index) {
        char c;
        c = s.charAt(index);
        return c;
    }

    //获取c的索引，在0到R-1之间
    int toIndex(char c) {
        int index;
        index = s.indexOf(c);
        return index;
    }

    //c在字母表之中吗？
    boolean contains(char c) {

        char[] a = s.toCharArray();
        for (char anA : a) {
            if (anA == c) {
                return true;
            }
        }
        return false;
    }


    //基数 （字母表中的字符数量）
    int R() {
        return s.length();
    }

    //表示一个索引所需的比特数
    int lgR() {
        //换底公式logX(y)= loge(y)/loge(x);
        int lgR;
        lgR = (int) (Math.log((s.length())) / (Math.log(2.0)));
        return lgR;
    }

    //将s转化为R进制的整数
    int[] toIndices(String s) {

        char[] source = s.toCharArray();
        int[] target = new int[s.length()];
        for (int i = 0; i < source.length; i++) {
            target[i] = toIndex(source[i]);
        }
        return target;
    }

    //把整數转化为基于该字母表的字符串
    String toChars(int[] indices) {
        StringBuilder s = new StringBuilder(indices.length);
        for (int i = 0; i < indices.length; i++)
            s.append(toChar(indices[i]));
        return s.toString();


    }

}
