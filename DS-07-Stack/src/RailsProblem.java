import java.io.PrintWriter;
import java.sql.SQLOutput;
import java.util.*;

public class RailsProblem {
    private static class Solution {
        public void run(Scanner in, PrintWriter out) {
            while (true) {
                int n = in.nextInt(); //0 or n
                if (n == 0) break;

                while (true) {
                    int x = in.nextInt(); // 0 or a[1]
                    if (x == 0) break;

                    int current = 1; // pointer to the first number not in the stack yet
                    boolean success = true;
                    Stack<Integer> s = new Stack<>();
                    for (int i = 2; i <= n; i++) {
                        if (success) {
                            for (; current <= x; current++) {
                                s.push(current);
                            }
                            if (s.peek() != x) {
                                success = false;
                            } else {
                                s.pop();
                            }
                        }
                        x = in.nextInt(); // a[i], 2 <= i <= n
                    }
                    System.out.println(success ? "Yes" : "No");
                }
                System.out.println();

            }
        }

    }

}
