package DataStructure;

/**
 * Created by Lunar on 2016/3/18.
 * 基于线性探测的符号表
 * 使用大小为M的数组保存N个键值对，依靠数组中的空位解决碰撞冲突
 * 开放地址法，线性探测法
 * 使用并行数组，一个保存键，一个保存值
 * N/M表示数组的利用率 而拉链法则表示平均每条链的长度
 * 对于线性探测法进行长度的resize是必要的因为
 * 可能会满，造成无限循环，查找时间也会变长
 */
public class LinearProbingHashST<Key, Value> {
    private int N;//符号表中键值对的对数
    private int M;//二个数组的长度，线性探测表的大小
    private Key[] keys;
    private Value[] values;//键值数组

    public LinearProbingHashST(int M) {
        keys = (Key[]) new Object[M];
        values = (Value[]) new Object[M];
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    private void resize() {
    }

    public void put(Key key, Value value) {
        if (N >= M) resize(2 * M);
        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % M)
            if (keys[i].equals(key)) {
                values[i] = value;
                return;
            }
        keys[i] = key;
        values[i] = value;
        N++;
    }

    public Value get(Key key) {
        for (int i = hash(key); keys[i] != null; i = (i + 1) % M) {
            if (keys[i].equals(key))
                return values[i];

        }
        return null;
    }

    private boolean contains(Key key) {
        return get(key) == null;
    }

    public void delete(Key key) {
        if (!contains(key)) return;
        int i = hash(key);
        while (!key.equals(keys[i])) {
            i = (i + 1) % M;
            keys[i] = null;
            values[i] = null;
            i = (i + 1) % M;
            //后边的每一个不是空的键值数组中存放的键值都首先自己为空然后重新put插入到数组中，都完毕后说明删除了一个
            //所以N键值数组少一个（因为删除的原因）
            while (keys[i] != null) {
                Key keyToRedo = keys[i];
                Value valToRedo = values[i];
                keys[i] = null;
                values[i] = null;
                N--;
                put(keyToRedo, valToRedo);
                i = (i + 1) % M;

            }
            N--;
            if (N > 0 && N == M / 8) resize(M / 2);
        }
    }

    private void resize(int cap) {
        //新建个表（临时的）然后再重新插入到新表，然后新表的键值数组赋值给原数组即可
        LinearProbingHashST<Key, Value> t;
        t = new LinearProbingHashST<>(cap);
        for (int i = 0; i < M; i++) {
            if (keys[i] != null) {
                t.put(keys[i], values[i]);

            }
            keys = t.keys;
            values = t.values;
            M = t.M;
        }
    }
}
