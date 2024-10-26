package HEAP;

import java.util.*;

// Main class for heap sort algorithm implementation
public class heapSort {

    // Method to sort the ArrayList using heap sort algorithm
    private static void sorting(ArrayList<Integer> arr) {
        int n = arr.size(); // Get the size of the ArrayList

        // Step 1: Build a max heap by calling heapify for all non-leaf nodes
        // Start from the last non-leaf node and go upwards
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Step 2: One by one extract elements from the heap and move them to the end
        // of the array, reducing the heap size each time
        for (int i = n - 1; i > 0; i--) {
            // Swap the root (largest element) with the last element of the heap
            Collections.swap(arr, 0, i);

            // Call heapify on the reduced heap to restore the heap property
            heapify(arr, i, 0);
        }
    }

    // Method to maintain the heap property in a subtree rooted at index 'i'
    private static void heapify(ArrayList<Integer> arr, int n, int i) {
        // Initialize largest as the root
        int largest = i;
        int left = 2 * i + 1; // Left child index
        int right = 2 * i + 2; // Right child index

        // If the left child exists and is larger than the root, update largest
        if (left < n && arr.get(left) > arr.get(largest)) {
            largest = left;
        }

        // If the right child exists and is larger than the current largest, update largest
        if (right < n && arr.get(right) > arr.get(largest)) {
            largest = right;
        }

        // If the largest is not the root, swap the root with the largest child
        if (largest != i) {
            // Swap the elements at index 'i' and 'largest'
            Collections.swap(arr, i, largest);
            // int temp = arr.get(i);
            // arr.set(i, arr.get(largest));
            // arr.set(largest, temp);

            // Recursively heapify the affected subtree
            heapify(arr, n, largest);
        }
    }

    // Main method - Entry point of the program
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Create a scanner for input
        int n = sc.nextInt(); // Input size of the array
        ArrayList<Integer> arr = new ArrayList<>(n); // Create an ArrayList to store elements

        // Input all elements of the array
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }

        // Call the sorting method to sort the ArrayList using heap sort
        sorting(arr);

        // Output the sorted array
        for (int i = 0; i < n; i++) {
            System.out.print(arr.get(i) + " ");
        }

        sc.close(); // Close the scanner to prevent resource leak
    }

}
