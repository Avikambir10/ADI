package Greedy;

import java.io.*;
import java.util.*;

public class Fractional_Knapsack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input
        int n = sc.nextInt();
        int[] val = new int[n];
        int[] weight = new int[n];
        for (int i = 0; i < n; i++) val[i] = sc.nextInt();
        for (int i = 0; i < n; i++) weight[i] = sc.nextInt();
        int capacity = sc.nextInt();

        // Output
        System.out.printf("%.2f\n", fractionalKnapsack(val, weight, n, capacity));
    }

    static class Item {
        int value, weight;
        double ratio;

        Item(int value, int weight) {
            this.value = value;
            this.weight = weight;
            this.ratio = (double) value / weight;
        }
    }

    private static double fractionalKnapsack(int[] val, int[] weight, int n, int capacity) {
        // Create a list of items with value, weight, and value-to-weight ratio
        Item[] items = new Item[n];
        for (int i = 0; i < n; i++) {
            items[i] = new Item(val[i], weight[i]);
        }
        // Sort items by value-to-weight ratio in descending order
        Arrays.sort(items, (a, b) -> Double.compare(b.ratio, a.ratio));

        double maxvalue = 0;
        for (Item item : items) {
            if (capacity >= item.weight) {
                maxvalue += item.value;
                capacity -= item.weight;
            } else {
                //take the fraction of the item
                maxvalue += item.ratio * capacity;
                break;
            }
        }
        return maxvalue;
    }
}