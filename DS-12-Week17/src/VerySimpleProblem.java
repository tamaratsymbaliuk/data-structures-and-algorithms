import java.io.*;

public class VerySimpleProblem {
    //https://informatics.msk.ru/mod/statements/view.php?id=1966&chapterid=490#1
    private static class Solution {
        private void run(InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int x = in.nextInt();
            int y = in.nextInt();

            int left = 0;
            int right = (int) 1e9;
            int answer = -1;
            n--; // First copy will be printed in Math.min(x,y) time. Next copies will utilize both printers.
            while (left <= right) {
                int middle = left + (right - left) / 2;
                // (middle / x ) copies on the first printer
                // (middle / y ) copies on the second printer
                if (middle / x + middle / y >= n) {
                    answer = middle;
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            }
            System.out.println(Math.min(x,y) + answer);
        }
    }

    public static void main(String[] args) {

        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputStreamReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Solution solution = new Solution();
    }
}