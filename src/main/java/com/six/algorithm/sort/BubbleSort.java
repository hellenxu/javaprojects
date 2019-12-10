package main.java.com.six.algorithm.sort;

import java.util.Scanner;

/**
 * Big O: O(N*N)
 * <p>
 * Created by Xiaolin on 2017-09-29.
 */
public class BubbleSort {

    static void bubbleSort(int numbers) {
        System.out.println(String.format("Please enter %d numbers: ", numbers));

        int[] num = new int[numbers];

        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < numbers; i++) {
            num[i] = scanner.nextInt();
        }

        int tmp, n = numbers - 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                if (num[j] < num[j + 1]) {
                    tmp = num[j];
                    num[j] = num[j + 1];
                    num[j + 1] = tmp;
                }
            }
        }

        for (int i = 0; i < numbers; i++) {
            System.out.printf("%d; ", num[i]);
        }
    }
}
