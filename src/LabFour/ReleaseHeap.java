package LabFour;

import java.util.Scanner;

public class ReleaseHeap {
    private static int[] heap = new int[100001];
    private static int size = 0;

    private static void insert(int value) {
        size++;
        heap[size] = value;
        siftUp(size);
    }

    private static int extract() {
        int max = heap[1];
        heap[1] = heap[size];
        size--;
        siftDown(1);
        return max;
    }

    private static void siftUp(int index) {
        while (index > 1 && heap[index / 2] < heap[index]) {
            swap(index, index / 2);
            index = index / 2;
        }
    }

    private static void siftDown(int index) {
        while (2 * index <= size) {
            int left = 2 * index;
            int right = 2 * index + 1;
            int largest = index;

            if (left <= size && heap[left] > heap[largest]) {
                largest = left;
            }
            if (right <= size && heap[right] > heap[largest]) {
                largest = right;
            }

            if (largest == index) {
                break;
            }

            swap(index, largest);
            index = largest;
        }
    }

    private static void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            int command = scanner.nextInt();
            if (command == 0) {
                int value = scanner.nextInt();
                insert(value);
            } else {
                System.out.println(extract());
            }
        }
    }
}
