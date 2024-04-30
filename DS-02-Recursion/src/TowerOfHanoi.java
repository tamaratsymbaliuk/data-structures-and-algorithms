import java.util.Scanner;

public class TowerOfHanoi {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numberOfDisks = in.nextInt();

        System.out.println("Minimum moves: ");
        //If n = 3, then 1 << 3 is shifting 1 in 00000001 3 positions to the left, resul in 00001000 (8 in decimal)
        //1 << n uses bitwise left shift operator <<. means you move the single 1 bit left by n bits.
        System.out.println((1 << numberOfDisks) - 1); // 1 << n same as 2^n
        hanoi(numberOfDisks, 1, 3, 2);
    }

    private static void hanoi(int numberOfDisks, int s, int f, int i) {
        if (numberOfDisks == 0) return;
        hanoi(numberOfDisks - 1, s, i, f);
        System.out.println(s + " " + f);
        hanoi(numberOfDisks - 1, i, f, s);
    }
}
