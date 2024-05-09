public class BeautifulArrangement_526 {
    private int count = 0;

    public int countArrangement(int n) {
        if (n == 0) return 0;
        boolean[] visited = new boolean[n + 1]; // tracks if a number is already used in the permutation
        backtrack(n, 1, visited);
        return count;
    }

    private void backtrack(int n, int position, boolean[] visited) {
        if (position > n) {
            count++; // if a valid permutation is found
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (!visited[i] && (i % position == 0 || position % i == 0)) {
                visited[i] = true;
                backtrack(n, position + 1, visited);
                visited[i] = false; // backtrack
            }
        }
    }

    public static void main(String[] args) {
        BeautifulArrangement_526 arrangement = new BeautifulArrangement_526();
        int n = 3;
        System.out.println("The number of beautiful arrangements for n = " + n + " is: " + arrangement.countArrangement(n));
    }
}
