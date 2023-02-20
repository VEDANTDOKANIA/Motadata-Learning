package org.example.DataStructure.Sorting;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {23, 4, 6, 45, 7, 6, 2, 90};

        MergeSort merge = new MergeSort();

        merge.sort(arr, 0, arr.length-1);

        for (int item : arr) {
            System.out.print(item+" ");
        }
    }

    public void sort(int[] arr, int start, int end) {
        if (start < end) {
            int mid = start + (end - start) / 2;

            sort(arr, start, mid);
            sort(arr, mid + 1, end);

            merge(arr, start, mid, end);

            System.out.println("Start: "+start+" | Mid: "+mid+" | End: "+end);
            for (int item : arr) {
                System.out.print(item + " ");
            }
            System.out.println();
        }
    }

    public void merge(int[] arr, int start, int mid, int end) {
        int[] left = new int[mid - start + 1];
        int[] right = new int[end - mid];

        for (int index = 0; index < left.length; index++) {
            left[index] = arr[index + start];
        }

        for (int index = 0; index < right.length; index++) {
            if (mid == 0) {
                System.out.println("aaaaaa: "+arr[index+1+mid]);
            }
            right[index] = arr[index + 1 + mid];
        }

        int leftIndex = 0;
        int rightIndex = 0;
        int index = start;

        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex] > right[rightIndex]) {
                if (mid == 0) {
                    System.out.println("aaaaaa: "+right[rightIndex]);
                }   
                arr[index] = right[rightIndex];
                rightIndex++;
            } else {
                arr[index] = left[leftIndex];
                leftIndex++;
            }
            index++;
        }

        while (leftIndex < left.length) {
            left[leftIndex] = arr[index];
            leftIndex++;
            index++;
        }

        while (rightIndex < right.length) {
            right[rightIndex] = arr[index];
            rightIndex++;
            index++;
        }
    }
} 