package HEAP;

import java.util.*;

public class Last_Stone_weight {

    public static void main(String[] args) {
        int[] nums = {100, 32, 93, 442, 21, 1, 4};
        System.out.println(weight(nums));
    }

    private static int weight(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int it : nums) {
            pq.add(it);
        }

        while (pq.size() > 1) {
            int x = pq.poll();
            int y = pq.poll();
            if (x != y) {
                pq.add(x - y);
            }
        }
        return pq.isEmpty() ? 0 : pq.poll();
    }
}
