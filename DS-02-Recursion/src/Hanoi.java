import java.util.Scanner;

public class Hanoi {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // n - number of disks
        hanoi(n,1,3);
    }

    public static void hanoi(int n, int from, int to) {
        if (n == 0) return;
        int aux = (1 + 2 + 3) - (from + to);
        hanoi(n - 1, from, aux);
        System.out.println(n + " " + from + " " + to);
        hanoi(n - 1, aux, to);
    }

}
