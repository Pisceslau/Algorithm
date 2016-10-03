package Algorithm;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Lunar on 2016/10/3.
 * 剑指Offer-面试题64-数据流中的中位数
 * 思路:使用最小堆和最大堆，Java中的优先队列PriorityQueue默认实现为最小堆。容器分为二部分，左部分作为大顶堆，右部分作为小顶堆。左边整体小于右边
 * 若是数据是偶数的，则向右边添加数据，也就是向小顶堆中添加数据。（先向大顶堆中添加，然后把大顶堆中的最大的拿出来给小顶堆）
 * 若是数据是奇数的，则向左边添加数据，也就是向大顶堆中添加数据。（先向小顶堆中添加，然后把小顶堆中的最小值拿出来给大顶堆）
 */
public class GetMedian {

    //优先队列默认实现了小顶堆
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    //大顶堆
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(15, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });

    //插入方法
    public void insert(Integer num) {
        //数据是偶数
        if (((minHeap.size() + maxHeap.size()) & 1) == 0) {
            //偶数要加入小顶堆，先进入大顶堆取最大的放小顶堆
            maxHeap.offer(num);
            int filterMaxNumber = maxHeap.poll();
            minHeap.offer(filterMaxNumber);
        } else {
            //奇数要加入大顶堆，先加入小顶堆中去最小的放入大顶堆中
            minHeap.offer(num);
            int filterMinNumber = minHeap.poll();
            maxHeap.offer(filterMinNumber);
        }
    }

    public Double getMedian() {

        //数据是奇数，说明原来小大都是偶数，在偶数的情况下加了数据根据前面是
        //加在了小顶堆中，于是现在小顶堆是奇数，大顶堆是偶数，所以取小顶堆那个数
        int size = minHeap.size() + maxHeap.size();
        if ((size & 1) == 1) {
            return new Double(minHeap.peek());
        } else {
            return (double) (minHeap.peek() + maxHeap.peek()) / 2;
        }
    }

    public static void main(String[] args) {
        GetMedian m = new GetMedian();
        m.insert(6);
        m.insert(7);
        m.insert(5);
        m.insert(10);
        System.out.print(m.getMedian());
    }
}
