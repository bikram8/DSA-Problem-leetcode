package Recursion;

public class sodoku {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {

        for (int i = 0; i < board.length; i++) {

            for (int j = 0; j < board[0].length; j++) {

                // Find empty cell
                if (board[i][j] == '.') {

                    // Try digits 1 to 9
                    for (char c = '1'; c <= '9'; c++) {

                        if (isValid(board, i, j, c)) {

                            board[i][j] = c;

                            // Recursive call
                            if (solve(board))
                                return true;

                            // Backtrack
                            board[i][j] = '.';
                        }
                    }

                    // No valid number found
                    return false;
                }
            }
        }

        // Sudoku solved
        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char c) {

        for (int i = 0; i < 9; i++) {

            // Check row
            if (board[row][i] == c)
                return false;

            // Check column
            if (board[i][col] == c)
                return false;

            // Check 3x3 box
            if (board[3 * (row / 3) + i / 3]
                    [3 * (col / 3) + i % 3] == c)
                return false;
        }

        return true;
    }

    // Print board
    private static void printBoard(char[][] board) {

        for (int i = 0; i < 9; i++) {

            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }

            System.out.println();
        }
    }

    // Main function
    public static void main(String[] args) {

        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };

        sodoku obj = new sodoku();

        System.out.println("Sudoku Before Solving:\n");
        printBoard(board);

        obj.solveSudoku(board);

        System.out.println("\nSudoku After Solving:\n");
        printBoard(board);
    }
}
