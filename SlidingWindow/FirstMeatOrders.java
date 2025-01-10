package SlidingWindow;

import java.util.*;

public class FirstMeatOrders {
    public static List<Integer> firstMeatOrders(int numOfOrders, int[] orders, int size) {
        List<Integer> result = new ArrayList<>();

        // Iterate through each sliding window
        for (int i = 0; i <= numOfOrders - size; i++) {
            boolean meatOrderFound = false;

            // Check the current window of size 'size'
            for (int j = i; j < i + size; j++) {
                if (orders[j] < 0) { // Meat-based pizza order
                    result.add(orders[j]);
                    meatOrderFound = true;
                    break;
                }
            }

            // If no meat-based order is found, append 0
            if (!meatOrderFound) {
                result.add(0);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input parsing
        int numOfOrders = sc.nextInt();
        int[] orders = new int[numOfOrders];
        for (int i = 0; i < numOfOrders; i++) {
            orders[i] = sc.nextInt();
        }
        int size = sc.nextInt();
        sc.close();
        // Function call and result output
        List<Integer> output = firstMeatOrders(numOfOrders, orders, size);
        for (int num : output) {
            System.out.print(num + " ");
        }
    }
}




/* 
Program Details 
A pizza shop makes vegan pizzas as well as meat based pizzas. The customers place N orders at the shop and their order number gets printed on thier bill.
The shop displays K out of N both - vegan and meat based pizza orders on thier display screen at a single time.The pizza shop is very famous and receives many orders. 
So to avoid confusion, the vegan pizza orders are displayed as a positive order number and the meat based pizza orders are displayed as a negative order number.
All the orders are delivered in the order in which they are displayed on the screen.Each time a displayed order is ready, it is then removed from the display screen and 
the next order is added to the display at the end.

A couple has come to eat pizza with their child Billy. Billy is a very naughty child and to keep him busy, 
his parents tell him to make a list of the first meat nased pizza order number present in each set of K orders displayed on the shop's display scrren.

Write an algorithm to help Billy make a list of the first meat based pizza order numbers displayed on the screen each time an order is delivered to a customer.

Input:
The first line of the input consists of two space-separated integers - numofOrders and size, representing the total number of orders placed (N) and the number
of orders displayed on the screen (K), respectively.
The second line consists of N space-separated integers representing the vegan pizza and meat based pizza order numbers of the orders placed by the customers.

Output:
Print a list of space-separated integers representing the first meat based pizza order of every K orders displayed on the screen each time an order is
delivered to a customer and print 0 it the screen does not display any meat based pizza order.

Constraints:
0 <= numofOrders <= 10^6
0 <= size <= numofOrders
-10^9 <= ordersNum <= 10^9; where orderNum represents the order numbers of the orders placed.

Example:
Input:
6,3
-11 -2 19 37 64 -18
Output:
-11 -2 0 -18

Explanation:
Step 1: At the time of the first display, the order numbers displayed are [-11,-2,19].
        So, the first displayed meat based pizza order number is -11.
Step 2: At the time of the next display, the order numbers displayed are [-2,19,37].
        So, the first displayed meat based pizza order number is -2.
Step 3: At the time of the next display, the order numbers displayed are [19,37,64].
        Since no meat based pizza order is displayed, the output is 0.
Step 4: Similarly, at the time of the next display, the order numbers displayed are [37,64,-18].
        So, the first displayed meat based pizza order number is -18.
So, the output is [-11,-2,0,-18].
 */