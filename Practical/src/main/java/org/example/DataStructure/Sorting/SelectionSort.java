package org.example.DataStructure.Sorting;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {23, 4, 6, 45, 7, 6, 2, 90};

        for (int index = 0; index < arr.length; index++) {
            int min_index = index;
            for (int j = index+1; j < arr.length; j++) {
                if (arr[j] < arr[min_index]) {
                    min_index = j;
                }
            }

            int tem = arr[min_index];
            arr[min_index] = arr[index];
            arr[index] = tem;
        }

        for (int item : arr) {
            System.out.print(item+" ");
        }
    }
}