package com.six.datastructure.stack;


import java.util.Scanner;

public class Palindrome {

    public static void main(String[] args) {
        System.out.println("Please enter a string: ");
        Scanner scanner = new Scanner(System.in);
        final String temp = scanner.next();

        char[] input = temp.toCharArray();
        final int len = input.length;
        char[] swap = new char[len];
        int mid = len / 2 - 1;
        int top = 0;
        for (int i = 0; i <= mid; i++) {
            swap[top] = input[i];
            top++;
        }

        int next;
        if (len % 2 == 0) {
            next = mid + 1;
        } else {
            next = mid + 2;
        }

        for (int i = next; i < len; i++) {
            top--;
            if (input[i] != swap[top]) {
                break;
            }
        }

        if (top == 0) {
            System.out.println(String.format("%s is a palindrome...", temp));
        } else {
            System.out.println(String.format("%s is not a palindrome...", temp));
        }
    }
}
