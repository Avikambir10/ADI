package Greedy;

import java.util.*;

public class Interviewscheduling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input
        int n = sc.nextInt();
        int[] start = new int[n];
        int[] end = new int[n];

        for (int i = 0; i < n; i++) start[i] = sc.nextInt();
        for (int i = 0; i < n; i++) end[i] = sc.nextInt();

        // Output
        System.out.println(intervalScheduling(start, end));
    }

    static int intervalScheduling(int[] start, int[] end) {
        int n = start.length;
        int[][] intervalcombine = new int[n][2];

        // Combine start and end times into intervals array
        for (int i = 0; i < n; i++) {
            intervalcombine[i][0] = start[i];
            intervalcombine[i][1] = end[i];
        }
        // Sort intervals by end time
        Arrays.sort(intervalcombine, (a, b) -> Integer.compare(a[1], b[1]));

        int cnt = 0;
        int lastendtime = -1;// End time of last selected interval

        // Iterate through sorted intervals
        for (int i = 0; i < n; i++) {
            if (intervalcombine[i][0] >= lastendtime) {
                cnt++;
                lastendtime = intervalcombine[i][1];
            }
        }
        return cnt;
    }
}
