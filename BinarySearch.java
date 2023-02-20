public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {10, 13, 15, 20, 21, 56, 88};

        BinarySearch bs = new BinarySearch();
        bs.search(arr, 15);
    }

    public void search(int[] arr, int key) {
        int start = 0;
        int end = arr.length-1;
        

        while (end >= start) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == key) {
                System.out.println("Found: "+mid);
                return;
            }

            if (arr[mid] > key) {
                // left
                end = mid - 1;
            } else {
                // right
                start = mid + 1;
            }
        }

        System.out.println("Element not found");
    }
}