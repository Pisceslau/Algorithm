package sort;

/**
 * Created by Lunar on 2016/1/19.
 */
public class InsertionAgain2 {
    public static void sort(int[] a){
        for(int i = 1;i<a.length;i++){
            for(int j = i;j>0;j--){
                if(a[j]<a[j-1]){
                    int t = a[j];
                    a[j] = a[j-1];
                    a[j-1] = t;
                }
            }

        }
    }
    public static void main(String[] args){
        int[] a = {4, 5, 2, 6, 6, 3, 27, 6, 23, 86, 9};
        sort(a);
        for(int i =0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
    }


}
