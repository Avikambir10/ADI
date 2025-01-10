package Greedy;

import java.util.*;

public class ActivitySelection {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input
        int n = sc.nextInt();
        int[] start = new int[n];
        int[] finish = new int[n];

        for (int i = 0; i < n; i++) {
            start[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            finish[i] = sc.nextInt();
        }
        sc.close();
        // Output
        activitySelection(start, finish);
    }

    private static void activitySelection(int[] start, int[] finish) {
        int n = start.length;
        int[][] activites = new int[n][2];
        for (int i = 0; i < n; i++) {
            activites[i][0] = start[i];
            activites[i][1]= finish[i];
        }
        Arrays.sort(activites,(a,b)->Integer.compare(a[1],b[1]));

        List<Integer> selectedActivities = new ArrayList<>();
        selectedActivities.add(activites[0][0]);
        int lastfinishtime = activites[0][1];
        for (int i = 0; i < n; i++) {
            if (activites[i][0] >= lastfinishtime){
                selectedActivities.add(activites[i][0]);
                lastfinishtime = activites[i][1];

            }
        }
        // Print the selected activities' starting times in sorted order
        for (int startTime : selectedActivities) {
            System.out.print(startTime + " ");
        }

    }

}

