package org.example.DataStructure.Sorting;

public class HeapSort {

    public static void sort(int[] arr) {
        for (int index = (arr.length / 2) - 1; index >= 0; index--) {
            heapify(arr, arr.length, index);
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            int tem = arr[i];
            arr[i] = arr[0];
            arr[0] = tem;

            heapify(arr,i, 0);
        }
    }

    public static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = (2*i)+1;
        int right = (2*i)+2;

        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, n, largest);
        }

    }
    public static void main(String[] args) {
        int[] arr = {4,10,3,5,1};

        sort(arr);
        for (int index = 0; index < arr.length; index++) {
            System.out.println(arr[index]);
        }
    }
}
