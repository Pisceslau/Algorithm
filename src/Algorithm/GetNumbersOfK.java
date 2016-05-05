package Algorithm;

/**
 * Created by Lunar on 2016/5/5.
 */
public class GetNumbersOfK {
    public int getNumberOfK(int[] array, int k) {

        int number = 0;
        int length = array.length;

        if (array != null && length > 0) {
            int first = getFirstK(array, length, k, 0, length - 1);
            int last = getLastK(array, length, k, 0, length - 1);
            if (first > -1 && last > -1)
                number = last - first + 1;
        }
        return number;

    }

    private int getFirstK(int[] array, int length, int k, int start, int end) {


        if (start > end) return -1;

        int middleIndex = (start + end) / 2;
        int middleData = array[middleIndex];

        if (middleData == k) {
            if ((middleIndex > 0 && array[middleIndex - 1] != k) || middleIndex == 0)
                return middleIndex;
            else
                end = middleIndex - 1;
        } else if (middleData > k) {
            end = middleIndex - 1;
        } else {
            start = middleIndex + 1;
        }

        return getFirstK(array, length, k, start, end);
    }

    private int getLastK(int[] array, int length, int k, int start, int end) {

        if (start > end) return -1;
        int middleIndex = (start + end) / 2;
        int middleData = array[middleIndex];

        if (middleData == k) {
            if ((middleIndex < length - 1 && array[middleIndex + 1] != k) || middleIndex == length - 1)
                return middleIndex;
            else
                start = middleIndex + 1;
        } else if (middleData > k) {
            end = middleIndex - 1;
        } else {
            start = middleIndex + 1;
        }
        return getLastK(array, length, k, start, end);

    }
}
