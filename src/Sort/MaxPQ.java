package Sort;

/**
 * Created by Lunar on 2016/1/22.
 * 基于堆的优先队列
 */
public class MaxPQ<Key extends Comparable<Key>> {

    private Key[] pq;
    private int N = 0;//存储于pq[1..N]中，pq[0]没有使用

    public MaxPQ(int maxN) {
        pq = (Key[]) new Comparable[maxN + 1];
    }

    public boolean isEmpty() {
        return N == 0;
    }
    //N加一然后把加入的元素v置于最后，然后上浮到合适的位置
    public void insert(Key v) {
        pq[++N] = v;
        swim(N);
    }
    /*从pq[1]中得到需要返回的元素，然后将pq[N]移动到pq[1],将N减1并sink恢复堆的秩序
    将不再使用的pq[N+1]，设置为null,以便系统回收它所占用的空间*/
    public Key delmax() {
        Key max = pq[1];//从根节点得到最大元素
        exch(1, N--);//将其和最后一个节点交换
        pq[N + 1] = null;//防止对象游离
        sink(1);//恢复堆的有序性
        return max;
    }
    //比较大小
    public boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }
    //交换
    private void exch(int i, int j) {
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }



    //上浮
    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exch(k / 2, k);
            k = k / 2;
        }
    }
    //下沉
    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(j, j + 1)) j++;

            if (!less(k, j)) break;//如果父大于子，则跳出while循环
            exch(k, j);
            k = j;
        }
    }

}
