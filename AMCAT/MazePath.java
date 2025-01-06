package AMCAT;

public class MazePath {
    public static void main(String[] args) {
        // Test cases
        int[][] maze1 = { { 0, 0, 0 }, { 9, 1, 1 }, { 0, 1, 1 } };
        int[][] maze2 = { { 1, 1, 1 }, { 9, 1, 1 }, { 0, 1, 0 } };

        System.out.println(isPath(maze1)); // Expected output: 0
        System.out.println(isPath(maze2)); // Expected output: 1
    }

    public static int isPath(int[][] maze) {

        boolean[][] visited = new boolean[maze.length][maze[0].length]; // To track visited cells
        int startRow = 0, startCol = 0; // Assuming Mooshak starts at (0,0)

        // Call DFS to check if a path exists
        return dfs(maze, startRow, startCol, visited) ? 1 : 0;
    }

    // Depth-First Search to check if a path exists to the cheese
    private static boolean dfs(int[][] maze, int row, int col, boolean[][] visited) {
        // Check if the position is out of bounds or already visited or a wall (value 0)
        if (row < 0 || row >= maze.length || col < 0 || col >= maze[0].length || visited[row][col]
                || maze[row][col] == 0) {
            return false;
        }

        // Check if the current cell is the cheese (value 9)
        if (maze[row][col] == 9) {
            return true;
        }

        // Mark the current cell as visited
        visited[row][col] = true;

        // Explore all four possible directions: up, down, left, right
        boolean found =
                dfs(maze, row - 1, col, visited) || // Up
                dfs(maze, row + 1, col, visited) || // Down
                dfs(maze, row, col - 1, visited) || // Left
                dfs(maze, row, col + 1, visited); // Right

        // Backtrack: Unmark the current cell (optional, if you need to explore multiple
        // paths)
        visited[row][col] = false;

        return found;
    }
}
