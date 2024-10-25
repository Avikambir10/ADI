package HEAP;

public class Min_Heap {
    private static void heapify(int[] arr, int n, int i) {
        int smallest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        //If left child , and it is smaller than the root
        if (left < n && arr[left] < arr[smallest]) {
            smallest = left;
        }
        //If right child exists, and it is smaller than the root
        if (right < n && arr[right] < arr[smallest]) {
            smallest = right;
        }

        // If the largest is not the root, swap the root with the largest child
        if (smallest != i) {
            int temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;

            //heapify recursivly
            heapify(arr, n, smallest);
        }
    }

    private static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 3, 7, 6, 55, 9, 3, 7, 88, 4};
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
        printArr(arr);
    }
}
