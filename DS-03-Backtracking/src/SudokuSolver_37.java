public class SudokuSolver_37 {
    public static void main(String[] args) {

        SudokuSolver_37 test = new SudokuSolver_37();
        char[][] board = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        test.solveSudoku(board);
        printBoard(test.solveSudoku(board));

    }
    public char[][] solveSudoku(char[][] board) {
        // Start solving sudoku from the first cell
        solve(board, 0, 0);
        return board;
    }

    private boolean solve(char[][] board, int row, int col) {
        // Base case: If row is equal to board length, entire board has been filled
        if (row == board.length) {
            return true;
        }

        // Move to next row when current row is fully filled
        if (col == board[0].length) {
            return solve(board, row + 1, 0);
        }

        // Skip cells that are already filled
        if (board[row][col] != '.') {
            return solve(board, row, col + 1);
        }

        // Try different numbers in current cell
        for (char num = '1'; num <= '9'; num++) {
            if (isValidPlacement(board, row, col, num)) {
                board[row][col] = num; // Fill current cell with valid number

                // Move to next cell
                if (solve(board, row, col + 1)) {
                    return true;
                }

                // Backtrack to previous state if solution not found
                board[row][col] = '.';
            }
        }

        // No valid solution found
        return false;
    }

    private boolean isValidPlacement(char[][] board, int row, int col, char num) {
        // Check if num is already in the same row, column or 3x3 subgrid
        for (int i = 0; i < board.length; i++) {
            // Check row
            if (board[i][col] == num) {
                return false;
            }

            // Check column
            if (board[row][i] == num) {
                return false;
            }

            // Check 3x3 subgrid
            int subgridRow = 3 * (row / 3) + i / 3; // Calculate row index of subgrid
            int subgridCol = 3 * (col / 3) + i % 3; // Calculate column index of subgrid

            if (board[subgridRow][subgridCol] == num) {
                return false;
            }
        }

        // Placement is valid
        return true;
    }

    public static void printBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {   // Loop through each row
            for (int j = 0; j < board[i].length; j++) { // Loop through each column in the row
                System.out.println(board[i][j] + " "); // Print each character followed by a space
            }
            System.out.println(); // Print a new line after each row
        }
    }
}
