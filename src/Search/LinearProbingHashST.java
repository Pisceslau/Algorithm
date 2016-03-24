package Search;

/**
 * Created by Lunar on 2016/2/1.
 * 线性探测法的哈希表（散列表）实现
 */
public class LinearProbingHashST<Key, Value> {
    private int N;//键值对的数量
    private int M;//线性探测表
    private Key[] keys;//键数组
    private Value[] vals;//值数组

    public LinearProbingHashST() {
        keys = (Key[]) new Object[M];
        vals = (Value[]) new Object[M];
    }

    //构造函数指定容量的
    public LinearProbingHashST(int cap) {
        this.M = cap;
        keys = (Key[]) new Object[M];
        vals = (Value[]) new Object[M];

    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public void put(Key key, Value val) {
        if (N >= M / 2) resize(2 * M);//将M加倍
        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % M) {
            if (keys[i].equals(key)) vals[i] = val;
            return;
        }
        keys[i] = key;
        vals[i] = val;
        N++;
    }

    public Value get(Key key) {
        for (int i = hash(key); keys[i] != null; i = (i + 1) % M) {
            if (keys[i] == key) {
                return vals[i];
            }
        }
        return null;
    }

    //调整数组大小
    private void resize(int cap) {
        LinearProbingHashST<Key, Value> t;
        t = new LinearProbingHashST<>(cap);
        for (int i = 0; i < M; i++)
            if (keys[i] != null) t.put(keys[i], vals[i]);
        keys = t.keys;
        vals = t.vals;
        M = t.M;
    }

    //删除操作
    public void delete(Key key) {
        if (!contains(key)) return;
        int i = hash(key);
        if (!key.equals(keys[i]))
            i = (i + 1) % M;
        keys[i] = null;
        vals[i] = null;
        i = (i + 1) % M;
        //对于删除的键值对的后面的键值对如果不是空的话，要重新插入到表中
        while (keys[i] != null) {
            Key keyToRedo = keys[i];
            Value valToRedo = vals[i];

            keys[i] = null;
            vals[i] = null;
            N--;
            put(keyToRedo, valToRedo);
            i = (i + 1) % M;
        }
        N--;
        //太小的话调整数组大小
        if (N > 0 && N == M / 8) resize(M / 2);



    }

    private boolean contains(Key key) {
        return get(key)==null;
    }

}
