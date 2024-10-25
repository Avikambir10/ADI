package BackTracking;

/**
 * AllPaths
 */
public class AllPaths {

        public static void main(String[] args) {
        boolean[][] board = {
                { true, true, true },
                { true, true, true },
                { true, true, true }
        };
        allpath("", 0, 0, board);
    }

    static void allpath(String p, int r, int c, boolean[][] board) {
        if (r == board.length - 1 && c == board[0].length - 1) {
            System.out.println(p);
            return;
        }
        if (!board[r][c]) {
            return;
        }
        board[r][c] = false;
        if (r < board.length - 1) {
            allpath(p + 'D', r + 1, c, board);
        }
        if (c < board[0].length - 1) {
            allpath(p + 'R', r, c + 1, board);
        }
        if (c > 0) {
            allpath(p + 'L', r, c - 1, board);
        }
        if (r > 0) {
            allpath(p + 'U', r - 1, c, board);
        }
        board[r][c] = true;
    }
}