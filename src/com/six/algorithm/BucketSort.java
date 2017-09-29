package com.six.algorithm;

import java.util.Scanner;

/**
 * 10 scores: 3, 5, 7, 1, 0, 10, 8, 9, 6, 7
 * Requirements: output scores from high to low
 * <p>
 * Created by Xiaolin on 2017-09-28.
 */

public class BucketSort {

    public static void main(String[] args) {
        //initialization
        int[] scores = new int[11];
        int size = 11;
        for (int i = 0; i < size; i++) {
            scores[i] = 0;
        }

        System.out.println("Please input 10 numbers that not larger than 10.");
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            ++scores[scanner.nextInt()];
        }

        //show results
        for (int i = size - 1; i > 0; i--) {
            for (int j = 1; j <= scores[i]; j++) {
                System.out.printf("%d ; ", i);
            }
        }
    }
}
