package Algorithm;

/**
 * Created by E440 on 2016/1/16.
 */
public class ST<Key,Value>{
    //符号表API

    private Key key;
    private Value val;
    public Key[] keys;
    public Value[] values;
    public ST(){}
    void put(Key key,Value val){
        //如果值为空，则删除键Key
        if(val==null){
            delete(key);
        }
        else{
            int[] a = new int[100];
            for(int i = 0;i<keys.length;i++){
                keys[i]=key;
                for(int j = 0;i<values.length;j++){
                    values[j]=val;
                }
            }
        }
    }
    //获取键Key所对应的值（若键Key不存在则返回null）
    Value get(Key key){
        if(key==null){
            return null;
        }
        return val;
    }
    //删除键key
    void delete(Key key){
        this.key = null;
        this.val = null;
    }
    //表是否为空？
    boolean isEmpty(){
        return key == null && val == null;
    }
    //表中键值对数量
    int size(){
        if (key instanceof String){}
        return ((String) key).length();
    }

}
