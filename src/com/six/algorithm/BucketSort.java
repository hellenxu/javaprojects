package com.six.algorithm;

import java.util.Scanner;

/**
 * 10 scores: 3, 5, 7, 1, 0, 10, 8, 9, 6, 7
 * Requirements: output scores from high to low
 * Big O: O(2*(M + N)) ≈ O(M + N)
 * M: the amount of buckets
 * N: the amount of numbers
 * <p>
 * Created by Xiaolin on 2017-09-28.
 */

public class BucketSort {

    static void bucketSort(int buckets, int numbers) {
        int[] scores = new int[buckets];
        for (int i = 0; i < buckets; i++) {
            scores[i] = 0;
        }

        System.out.printf("Please input %d numbers that not larger than %d: ", numbers, buckets - 1);
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < numbers; i++) {
            ++scores[scanner.nextInt()];
        }

        for (int i = buckets - 1; i > 0; i--) {
            for (int j = 1; j <= scores[i]; j++) {
                System.out.printf("%d; ", i);
            }
        }

    }
}
