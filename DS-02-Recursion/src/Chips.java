import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.IOException;

public class Chips {
    private static class Solution {
        private BufferedReader in_;  // Use BufferedReader for input
        private PrintWriter out_;

        private void put(int n) throws IOException {
            if (n == 1) {
                out_.print("1 ");
                return;
            }
            put(n - 1);
            out_.print(n + " ");
            remove(n - 1);
        }
        private void remove(int n) throws IOException {
            if (n == 1) {
                out_.print("-1 ");
                return;
            }
            put(n - 1);
            out_.print(-n + " ");
            remove(n - 1);
        }
        public void run(BufferedReader in, PrintWriter out) throws IOException {
            in_ = in;
            out_ = out;

            // Read the input
            int n = Integer.parseInt(in_.readLine());  // Use readLine() to read input as string and then parse it
            for (int i = n; i >= 1; i--) {
                put(i);
            }
            out_.println();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);
        new Solution().run(reader, writer);
        writer.flush();
    }
}
