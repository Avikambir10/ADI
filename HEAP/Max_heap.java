package HEAP;

public class Max_heap {
    private static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        //If left child , and it is larger than the root
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }
        //If right child exists, and it is larger than the root
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // If the largest is not the root, swap the root with the largest child
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            //heapify recursivly
            heapify(arr, n, largest);
        }
    }

    private static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 3, 7, 6, 55, 9, 3, 7, 88, 4};
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
        printArr(arr);
    }
}
