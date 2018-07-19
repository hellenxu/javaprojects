package com.six.algorithm.search;


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

    //TODO
    static int rotatedArray(int[] array, int value) {

        return -1;
    }

    //TODO
    static String sparseEmptyArray(String[] array, String value) {
        return null;
    }

    //TODO
    static int unKnownSizeArray(int[] array, int value) {

        return -1;
    }
}
