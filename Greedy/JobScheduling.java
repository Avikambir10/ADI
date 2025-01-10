package Greedy;

import java.util.*;

public class JobScheduling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] deadlines = new int[n];
        int[] profits = new int[n];

        for (int i = 0; i < n; i++) {
            deadlines[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            profits[i] = sc.nextInt();
        }

        sc.close();
        // Output
        System.out.println(jobScheduling(deadlines, profits));
    }

    static class Job {
        int deadline;
        int profit;

        Job(int deadline, int profit) {
            this.deadline = deadline;
            this.profit = profit;
        }
    }

    static int jobScheduling(int[] deadlines, int[] profits) {
        int n = deadlines.length;

        Job[] jobs = new Job[n];
        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(deadlines[i], profits[i]);
        }

        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);

        int maxprofit = 0;
        // Track available time slots (we only care about deadlines <= 100)
        int[] timeslots = new int[101];  // To keep track of the time slots used

        // Process each job in the sorted order
        for (int i = 0; i < n; i++) {
            // Find the latest available time slot before the job's deadline
            for (int j = jobs[i].deadline; j > 0; j--) {
                if (timeslots[j] == 0) {
                    // Slot is available, schedule the job
                    timeslots[j] = 1;  // Mark this time slot as used
                    maxprofit += jobs[i].profit;  // Add the profit
                    break;  // Move to the next job
                }
            }

        }
        return maxprofit;
    }
}
