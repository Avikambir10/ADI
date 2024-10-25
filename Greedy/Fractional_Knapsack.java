package Greedy;

import java.io.*;
import java.util.*;

// Class to represent an item with value and weight
class Item {
    int value, weight;

    // Constructor to initialize value and weight of the item
    Item(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }
}

public class Fractional_Knapsack {

    // Main function to handle input and output
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Number of test cases

        while (t-- > 0) {
            // Read values array
            String[] valueInput = br.readLine().trim().split(" ");
            List<Integer> values = new ArrayList<>();
            for (String s : valueInput) {
                values.add(Integer.parseInt(s));
            }

            // Read weights array
            String[] weightInput = br.readLine().trim().split(" ");
            List<Integer> weights = new ArrayList<>();
            for (String s : weightInput) {
                weights.add(Integer.parseInt(s));
            }

            // Read the knapsack capacity
            int w = Integer.parseInt(br.readLine().trim());

            // Create array of Item objects
            Item[] items = new Item[values.size()];
            for (int i = 0; i < values.size(); i++) {
                items[i] = new Item(values.get(i), weights.get(i));
            }

            // Call fractionalKnapsack function and print result
            System.out.println(String.format("%.6f", fractionalKnapsack(w, items, items.length)));
        }
    }

    // Function to calculate maximum value we can get in the knapsack
    static double fractionalKnapsack(int w, Item[] items, int n) {
        // Sort items based on value/weight ratio in decreasing order
        Arrays.sort(items, (a, b) -> Double.compare((double) b.value / b.weight, (double) a.value / a.weight));

        double totalValue = 0.0;  // Variable to store the maximum value
        double remainingCapacity = w;  // Remaining capacity of the knapsack

        for (int i = 0; i < n; i++) {
            if (items[i].weight <= remainingCapacity) {
                // If item can fit completely in the knapsack, take the whole item
                totalValue += items[i].value;
                remainingCapacity -= items[i].weight;
            } else {
                // If the item cannot fit completely, take the fraction that fits
                totalValue += items[i].value * (remainingCapacity / items[i].weight);
                break;  // Knapsack is full
            }
        }

        return totalValue;  // Return the maximum value obtained
    }
}

