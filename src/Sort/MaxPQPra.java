package Sort;

/**
 * Created by Lunar on 2016/3/15.
 * 最大堆练习
 */
public class MaxPQPra {
    private int[] pq;//队列使用数组实现之
    private int N;//a[0]没有用，a[1]到a[N]用来存储

    //构造方法
    public MaxPQPra(int N) {
        pq = new int[N + 1];
    }

    //判断是不是为空
    public boolean isEmpty() {
        return N == 0;
    }

    //大小
    public int size() {
        return N;
    }

    //下沉操作
    public void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && pq[j] < pq[j + 1]) j++;//父结点应该和子节点中的大的交换才行！
            if (pq[j] < pq[k]) break;
            int temp = pq[j];
            pq[j] = pq[k];
            pq[k] = temp;
            k = j;
        }
    }

    //上浮操作
    public void swim(int k) {
        //因为第0索引没存储，所以大于1
        while (k > 1 && pq[k] > pq[k / 2]) {
            int temp = pq[k];
            pq[k] = pq[k / 2];
            pq[k / 2] = temp;
            k = k / 2;
        }
    }

    //删除最大元素
    public int delMax() {
        //先把根结点与最后一个结点交换
        int temp = pq[1];
        pq[1] = pq[N--];
        pq[N--] = temp;
        pq[N + 1] = 0;
        sink(1);
        return temp;
    }
}
