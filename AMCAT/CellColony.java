package AMCAT;

// There is a colony of 8 cells arranged in a straight line where each day every cell competes with its adjacent cells(neighbour). Each day, for each cell, if its neighbours are both active or both inactive, the cell becomes inactive the next day,. otherwise itbecomes active the next day.

// Assumptions: The two cells on the ends have single adjacent cell, so the other adjacent cell can be assumsed to be always inactive. Even after updating the cell state. consider its pervious state for updating the state of other cells. Update the cell informationof allcells simultaneously.

// Write a fuction cellCompete which takes takes one 8 element array of integers cells representing the current state of 8 cells and one integer days representing te number of days to simulate. An integer value of 1 represents an active cell and value of 0 represents an inactive cell.

public class CellColony {
    public static void main(String[] args) {
        int[] cells = { 1, 0, 0, 1, 0, 0, 1, 1 };
        int days = 3;

        int[] result = cellCompete(cells, days);

        // Print the result after the given days
        for (int cell : result) {
            System.out.print(cell + " ");
        }
    }

    static int[] cellCompete(int[] cell, int days) {
        int[] res = new int[cell.length];

        for (int day = 0; day < days; day++) {
            for (int i = 0; i < cell.length; i++) {
                if (i == 0) {
                    res[i] = (cell[i + 1] == 0) ? 0 : 1;
                } else if (i == cell.length - 1) {
                    res[i] = (cell[i - 1] == 0) ? 0 : 1;
                } else {
                    res[i] = (cell[i + 1] == cell[i - 1]) ? 0 : 1;
                }
            }
            System.arraycopy(res, 0, cell, 0, cell.length);
        }

        return cell;
    }
}
