package org.example.DataStructure.Sorting;

public class InsertionSort {

    public static void sort(int[] arr) {
        for (int index = 1; index < arr.length; index++) {
            int comp_index = index - 1;
            int key = arr[index];

            while (comp_index >=0 && arr[comp_index] > key) {
                arr[comp_index+1] = arr[comp_index];
                comp_index--;
            }

            arr[comp_index+1] = key;
        }
    }

    public static void main(String[] args) {
        int[] arr = {11,12,13,5,6};//{2,6,4,1,7,9,6};
        sort(arr);

        System.out.println(arr);
    }
}
