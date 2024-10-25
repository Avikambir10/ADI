package HEAP;

// connect sticks and find the total cost of joining them
import java.util.*;

public class Connect_Sticks {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 4 };
        System.out.println(helper(arr));
    }

    static int helper(int[] lengths) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int nums : lengths) {
            pq.add(nums);
        }
        int totalCost = 0;
        while (pq.size() > 1) {
            int x = pq.poll();
            int y = pq.poll();
            int cost = x + y;
            totalCost += cost;
            pq.add(cost);
        }
        return totalCost;
    }
}
