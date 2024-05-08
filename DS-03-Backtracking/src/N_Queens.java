import java.util.ArrayList;
import java.util.List;
//most optimized solution
public class N_Queens {
    private int dimension;
    private int[] row;
    private int[] diag_aux;
    private int[] diag_main;

    private List<List<String>> answers;
    private char[][] current;

    public List<List<String>> solveNQueens(int n) {
        dimension = n;

        row = new int[n];

        // when row = 0, col = n - 1 => row - col = 0 -(n - 1) = -(n-1) smallest value
        // row = n - 1, col = 0 => row - col = (n - 1) - 0 = n -1 largest value
        // so we add n so the indexes are not negative
        // row - col       => [-(n - 1) .. n - 1]
        // (row - col + n) => [1...2n - 1] possible range
        diag_main = new int[2 * n]; // row - col => [-(n - 1) .. n - 1] that's why size is 2n

        // min - row = 0, col = 0 => 0 + 0 = 0
        // max - row = n - 1, col = n - 1 => (n - 1) + (n - 1) = 2n - 2
        // row + col => [0 .. 2n - 2] possible range
        diag_aux = new int[2 * n];

        answers = new ArrayList<>();

        current = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                current[i][j] ='.';
            }
        }
        backtrack(0);
        return answers;
    }

    private void backtrack(int c) { // int c -> current column (current queen, queen #c)
        if (c == dimension) {
            // c = 0 -> c = 1 -> ... -> c = dimension - 1; when c == dimension means all queens are on the board

            // Saving the result to array of results
            List<String> result = new ArrayList<>();
            for (int i = 0; i < dimension; i++) {
                result.add(new String(current[i]));
            }
            answers.add(result);
            return;
        }

        // Trying to put queen #c at some row #r
        for (int r = 0; r < dimension; r++) { // r iterates from 0 to dimension - 1
            // checking if position (r, c) is valid
            //row[r] > 0 - queen in the same row?
            //diag_aux[r + c] > 0  - queen on the same aux diagonal?
            //diag_main[r - c + dimension - 1] > 0 - queen on the same main diagonal?
            if (row[r] > 0 || diag_aux[r + c] > 0 || diag_main[r - c + dimension - 1] > 0) {
                // (r, c) is not valid, skip
                continue;
            }
            current[r][c] = 'Q';
            row[r] = diag_aux[r + c] = diag_main[r - c + dimension - 1] = 1;
            backtrack(c + 1);
            current[r][c] = '.'; // important to leave a clean state
            row[r] = diag_aux[r + c] = diag_main[r - c + dimension - 1] = 0;
        }
    }


}
