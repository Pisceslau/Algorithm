package sort;

/**
 * Created by Lunar on 2016/1/20.
 */
public class MergeBT {
    private static int[] aux;

    public static void sort(int[] a) {
        int len = a.length;
        aux = new int[len];
        //sz是子数组的大小，1,2,4
        for (int sz = 1; sz < len; sz = sz + sz) {
            //lo 为子数组索引，lo+=sz+sz为跨越两个子数组（Merge后的一个大数组然后子数组的索引）
            for (int lo = 0; lo < len - sz; lo += sz + sz) {
                //lo+sz-1为mid，lo+=sz+sz为hi，lo+sz+sz-1=lo+sz-1(整数减去0.5和1一样)
                merge(a, lo, lo + sz - 1, min(lo + sz + sz - 1, len - 1));
            }
        }
    }

    private static void merge(int[] a, int lo, int mid, int hi) {
        int i = lo,j = mid +1;
        for(int k=lo;k<=hi;k++){
            aux[k] = a[k];
        }

        for(int k = lo ;k<= hi; k++){
            if(i>mid)               a[k] = aux[j++];
            else if (j>hi)          a[k] = aux[i++];
            else if (aux[j]<aux[i]) a[k] = aux[j++];
            else                    a[k] = aux[i++];
        }
    }


    //返回a，与b之间小的值
    public static int min(int a, int b) {
        return (a <= b) ? a : b;
    }

    public static void main(String[] args){
        int[] a = {1, 2, 6, 4, 3, 6, 7, 6, 4, 5, 89, 45};

        sort(a);

        for (int i = 0 ;i<a.length;i++){
            System.out.print(a[i] +" ");
        }
    }


}
