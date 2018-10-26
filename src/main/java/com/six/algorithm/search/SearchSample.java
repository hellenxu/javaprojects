package com.six.algorithm.search;

/**
 * Created by Xiaolin on 2018-01-03.
 */

public class SearchSample {
    public static void main(String[] args) {
        int[] array = {3, 6, 8, 11, 23, 56, 65, 76, 100};
        System.out.println(String.format("Index of %d is %d", 23, BinarySearch.normal(array, 23)));
        System.out.println(String.format("Index of %d is %d", 7, BinarySearch.normal(array, 7)));

        System.out.println(String.format("Index of %d is %d", 23, BinarySearch.recurring(array, 23, 0, array.length)));
        System.out.println(String.format("Index of %d is %d", 7, BinarySearch.recurring(array, 7, 0, array.length)));

        // rotated sorted array
        int[] array2 = {11, 23, 56, 65, 76, 100, 3, 6, 8};
        System.out.println(String.format("Index of %d is %d", 100, BinarySearch.rotatedSorted(array2, 100)));
        System.out.println(String.format("Index of %d is %d", 6, BinarySearch.rotatedSorted(array2, 6)));
        System.out.println(String.format("Index of %d is %d", 0, BinarySearch.rotatedSorted(array2, 0)));
    }

}
