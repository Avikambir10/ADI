package Employ;

import java.util.Scanner;

public class MartinJogging {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input: initial positions and parameters
        int fatherPos = scanner.nextInt();
        int martinPos = scanner.nextInt();
        int velFather = scanner.nextInt();
        int steps = scanner.nextInt();

        // Calculate father's total distance covered
        int fatherEndPos = fatherPos + velFather * steps;

        // Initialize maximum common footsteps and optimal velocity
        int maxCommonSteps = 0;
        int bestVelocity = 0;

        // Iterate over all possible velocities for Martin
        for (int velMartin = 1; velMartin <= velFather; velMartin++) {
            int martinCurrentPos = martinPos;
            int commonSteps = 0;

            // Simulate Martin's run
            for (int step = 0; step < steps; step++) {
                int fatherCurrentPos = fatherPos + velFather * step;

                if (martinCurrentPos == fatherCurrentPos) {
                    commonSteps++;
                }

                martinCurrentPos += velMartin;

                // If Martin surpasses father's final position, break early
                if (martinCurrentPos > fatherEndPos) {
                    break;
                }
            }

            // Update maximum common steps and velocity if necessary
            if (commonSteps > maxCommonSteps || (commonSteps == maxCommonSteps && velMartin > bestVelocity)) {
                maxCommonSteps = commonSteps;
                bestVelocity = velMartin;
            }
        }

        // Output the result
        System.out.println(maxCommonSteps + " " + bestVelocity);

        scanner.close();
    }
}

/* 
Martin's father goes for a jog every morning. Martin follows him several minutes later. His father starts at a position that is X1 metres away from their home and runs rectilinearly at a constant speed of V1 meters per step for N steps.
Martin is standing at X2 meters away from his home. He wonders how fast he must run at some constant speed of V2 meters per step so as to maximize F, where F equals the number of his father's footsteps that Martin will land on during his run.It is given that the first step that Martin will land on, from his starting position, will have been landed on by his father.
Note that if more than one prospective velocity results in the same number of maximum common steps, output the highest prospective velocity as V2.
Write an algorithm to help Martin calculate F and V2.

INPUT
The first line of the input consists of an integer fatherPos, representing the initial position of Martin's father(X1).
The second line consists of an integer martinPos, representing the initial position of Martin (X2).
The third line consits of an integer velFather, representing the velocity of father(V1).
The last line consists of integer steps , representing the no of steps taken by father(N).
 
OUTPUT
Print the two space-separated integers as the maximum number of common footsteps F and respective speed V2.
 
CONSTRAINTS
1 <= fatherPos < 105
0 <= martinPos <= fatherPos
1 <= velFather <= 104
1 <= steps <= 104
Example
Input:
3
2
2
20
Output:
21 1
Explanation:
Martin can save a maximum of 21 common footsteps with a velocity of 1 m/steps. 
*/
