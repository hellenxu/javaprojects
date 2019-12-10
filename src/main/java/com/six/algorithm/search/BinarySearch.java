package main.java.com.six.algorithm.search;

import javax.swing.text.html.HTML;

/**
 * Created by Xiaolin on 2018-01-03.
 */

public class BinarySearch {

    static int normal(int[] array, int value) {
        int low = 0, high = array.length - 1;
        int mid, midValue;
        while (low <= high) {
            mid = (high + low) >>> 1;
            midValue = array[mid];
            if (value < midValue) {
                high = mid - 1;
            } else if (value > midValue) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;  //not found
    }

    static int recurring(int[] array, int value, int low, int high) {
        int mid = (high + low) >>> 1;
        int midValue = array[mid];
        if (value > midValue) {
            low = mid + 1;
        } else if (value < midValue) {
            high = mid - 1;
        } else {
            return mid;
        }
        if (low <= high) {
            recurring(array, value, low, high);
        }
        return -1;
    }

    //search the index of target value in a rotated sorted array
    static int rotatedSorted(int[] array, int value) {
        int low = 0, high = array.length - 1;
        int mid = (low + high) >>> 1;
        return splitArray(array, value, low, mid, high);
    }

    private static int splitArray(int[] array, int value, int low, int mid, int high) {
        int targetIndex;
        int tmpLow, tmpMid, tmpHigh;

        if (array[low] >= array[mid]) {
            targetIndex = recurring(array, value, mid, high);
            tmpLow = low;
            tmpMid = (low + mid) >>> 1;
            tmpHigh = mid - 1;
        } else {
            targetIndex = recurring(array, value, low, mid - 1);
            tmpLow = mid;
            tmpMid = (mid + high) >>> 1;
            tmpHigh = high;
        }

        if (low <= high && targetIndex < 0) {
            targetIndex = splitArray(array, value, tmpLow, tmpMid, tmpHigh);
        }

        return targetIndex;
    }

    //TODO
    static int sparseEmptyArray(int[] array, int value) {

        return -1;
    }

    //TODO in this case, don't allow to use array.length
    static int unknownLengthArray(int[] array, int value) {
        return -1;
    }

}
