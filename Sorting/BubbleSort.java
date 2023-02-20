public class BubbleSort {
    public static void main(String[] arg) {
        int[] arr = {23, 4, 6, 45, 7, 6, 2, 90};

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j+1]) {
                    int tem = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tem;
                }
            }
        }

        for (int item : arr) {
            System.out.print(item+" ");
        }
    }
}