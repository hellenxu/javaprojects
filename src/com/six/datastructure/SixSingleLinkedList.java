package com.six.datastructure;

/**
 * @author hellenxu
 * @date 2017-08-04
 * Copyright 2017 Six. All rights reserved.
 */
public class SixSingleLinkedList {
    private SixNode head;
    private int length;

    public SixSingleLinkedList() {
        head = null;
        length = 0;
    }

    SixSingleLinkedList(SixNode head) {
        if (head == null)
            return;
        this.head = new SixNode(head.value, null);
        length++;
    }

    public int size() {
        return length;
    }

    void insertHead(SixNode newHead) {
        SixNode oldHead = new SixNode(head.value, head.next);
        head = new SixNode(newHead.value, oldHead);
        length++;
    }

    void insert(int index, SixNode item) {
        if (index <= 0 || index > length) {
            throw new IllegalArgumentException("invalid arguments");
        }
        SixNode previousNode = head, targetNode = head, newNode;
        for (int i = 0; i < index; i++) {
            previousNode = targetNode;
            targetNode = targetNode.next;
        }

        newNode = new SixNode(item.value, targetNode);
        previousNode.next = newNode;
        length++;
    }

    void remove(int index) {
        if (index < 0 || index > length - 1) {
            throw new IllegalArgumentException("invalid arguments");
        }

        if (index == 0) {
            head = head.next;
        } else {
            SixNode previousNode = head, targetNode = head;
            for (int i = 0; i < index; i++) {
                previousNode = targetNode;
                targetNode = targetNode.next;
            }
            previousNode.next = targetNode.next;
        }

        length--;
    }

    void clean() {
        head = null;
        length = 0;
    }

    SixNode getNode(int index) {
        if (index < 0 || index > length - 1) {
            throw new IllegalArgumentException("invalid arguments");
        }

        SixNode targetNode = head;
        for (int i = 0; i < index; i++) {
            targetNode = targetNode.next;
        }
        return targetNode;
    }

    @Override
    public String toString() {
        StringBuilder content = new StringBuilder();
        SixNode currentNode = head;
        for (int i = 0; i < length - 1; i++) {
            content.append(currentNode.value)
                    .append(" -> ");
            currentNode = currentNode.next;
        }
        if (!content.toString().isEmpty()) {
            content.append(currentNode.value);
        } else {
            content.append("empty list");
        }

        return content.toString();
    }
}
