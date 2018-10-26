package com.six.datastructure.queue;

import java.util.Scanner;

public class SixQueue {
    private int head, tail;
    private int[] data;

    public SixQueue(int capacity) {
        if (capacity < 1 || capacity > 100) {
            return;
        }
        head = 0;
        tail = capacity;
        data = new int[100];
        System.out.println(String.format("Please enter %d numbers: ", capacity));
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < capacity; i++) {
            data[i] = scanner.nextInt();
        }
    }

    public void crackCode() {
        while (head < tail) {
            System.out.printf("%d ", data[head]);
            head++;

            data[tail] = data[head];
            tail++;
            head++;
        }
    }

}
