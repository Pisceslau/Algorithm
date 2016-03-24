package Algorithm;

/**
 * Created by Lunar on 2016/3/9.
 * 剑指Offer47题的相关问题,不使用其他的变量来进行二个数的交换
 */
public class Exchange {
    public static void exchangeByAdd(int a, int b) {
        a = a + b;//二者之和
        b = a - b;//二者之和减去原b为原a赋值给b
        a = a - b;//二者之和减去原a为b,赋值为a于是实现了交换
        //Java中传值所以调用函数是无效的结果
    }
    //因为Java传值无效所以使用数组进行辅助
    static void exchange(int[]array,int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public static void main(String[] args) {


    }
}
