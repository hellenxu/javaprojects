package com.six.algorithm;

import java.util.Scanner;

/**
 * Big O: O(N*N) ~ O(NlogN)
 * <p>
 */

public class QuickSort {
    private static int num[] = new int[20];
    static void quickSort(int numbers) {

        System.out.println(String.format("Please enter %d numbers: ", numbers));

        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < numbers; i++) {
            num[i] = scanner.nextInt();
        }

        realQuickSort(0, numbers - 1);

        System.out.println("sorted: ");
        for(int i = 0; i < numbers; i ++) {
            System.out.printf("%d;", num[i]);
        }
    }

    private static void realQuickSort(int left, int right) {

        if(left > right) {
            return;
        }

        int leftIndex = left, rightIndex = right, temp, standard = num[left];

        while (leftIndex != rightIndex) {
            while (num[rightIndex] >= standard && leftIndex < rightIndex) {
                rightIndex --;
            }

            while (num[leftIndex] <= standard && leftIndex < rightIndex) {
                leftIndex ++;
            }

            if(leftIndex < rightIndex) {
                temp = num[leftIndex];
                num[leftIndex] = num[rightIndex];
                num[rightIndex] = temp;
            }
        }

        num[left] = num[leftIndex];
        num[leftIndex] = standard;

        realQuickSort(left, leftIndex - 1);
        realQuickSort(leftIndex + 1, right);
    }
}
