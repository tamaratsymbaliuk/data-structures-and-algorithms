import java.util.Scanner;

public class StringMatching {
    // Given a String a and a pattern, count the number of positions where there the pattern occurs in the string
    // Input: sjhfppffpp
    // pp
    // Output:2

    /*
    Brute-force solution: iterate over each m char in the string, count it's occurrence of pattern in a string
    Rabin-Karp hashing algorithm
     */

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String s = in.nextLine();
        String t = in.nextLine();

        int n = s.length();
        int m = t.length();

        long p = 9937;
        long mod = (long) 1e9 + 7;

        // First compute the hash of pattern ( String t)
        long h_t = 0;
        for (int i = 0; i < m; i++) {
            long c = t.charAt(i) - 'a'; // ASCII code of the current character
            h_t = (h_t * p + c) % mod;
        }

        // Second we compute hashes of each prefix of string (String s)
        long[] h_s = new long[n];
        h_s[0] = s.charAt(0) - 'a';
        for (int i = 1; i < n; i++) {
            // to compute the hash of the next prefix we use hash of the previous prefix * p and + ASCII code and take mod
            long c = s.charAt(i) - 'a';
            h_s[i] = (h_s[i - 1] * p + c) % mod;
        }

        // Compute (p^m) % mod
        long p_m = 1;
        for (int i = 0; i < m; i++) {
            p_m = p_m * p % mod;
        }

        int answer = 0;

        // Compare each m consecutive characters from string with pattern
        // Starting at prefix of length m
        for (int i = m - 1; i < n; i++) {
            long h = h_s[i];
            if (i > m - 1) {
                // Whenever we have 2 numbers a and b and we want to compute (a - b) % mod,
                // we actually need to compute (a - b + mod) % mod
                h = (h - h_s[i - m] * p_m % mod + mod) % mod;
            }
            if (h == h_t) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}
