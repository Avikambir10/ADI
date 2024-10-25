package BackTracking;

public class Maze_with_obstacles {
    public static void main(String[] args) {
        boolean[][] board = {
                { true, true, true },
                { true, false, true },
                { true, true, true }
        };
        path("", 0, 0, board);
    }

    static void path(String p, int r, int c, boolean[][] board) {
        if (r == board.length - 1 && c == board[0].length - 1) {
            System.out.println(p);
            return;
        }
        if (!board[r][c]) {
            return;
        }
        if (r < board.length-1) {
            path(p + 'D', r + 1, c, board);
        }
        if (c < board[0].length -1) {
            path(p + 'R', r, c + 1, board);
        }
    }
}