package main.java.com.six.datastructure.linkedlist;

/**
 * this linked list stores int only.
 */
public class SimulateLinkedList {
    private int[] data;
    private int[] rightIndex;
    private int size;
    private float rezieFactor;

    public SimulateLinkedList(int capacity) {
        if (capacity < 0) {
            return;
        }
        data = new int[capacity];
        rightIndex = new int[capacity];
        for (int i = 0; i < capacity; i++) {
            if (i != capacity - 1) {
                rightIndex[i] = i + 1;
            } else {
                rightIndex[i] = -1;
            }
        }
        size = 0;
        rezieFactor = 0.75f;
    }

    public int size() {
        return size;
    }

    public void add(int value) {
        needToResize();
        data[size] = value;
        rightIndex[size] = -1;
        size++;
    }

    private void needToResize() {
        if (size >= data.length * rezieFactor) {
            int[] temp = data, indices = rightIndex;
            data = new int[temp.length * 2];
            rightIndex = new int[indices.length * 2];
            for (int i = 0; i < temp.length; i++) {
                data[i] = temp[i];
                rightIndex[i] = indices[i];
            }
        }
    }
}
