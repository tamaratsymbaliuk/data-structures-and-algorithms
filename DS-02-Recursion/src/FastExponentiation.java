import java.util.Scanner;

public class FastExponentiation {
    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here
        Scanner in = new Scanner (System.in);
        int t = in.nextInt();
        while (t > 0){
            t--;
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(fastExp(a,b));

        }

    }

    private static int fastExp(int a, int b){
        if (b == 0) return 1;
        int x = fastExp(a, b / 2);//floor the result; If b = 5, then b / 2 = 2.5 but it will be truncated to 2
        long result = x * 1L * x % 1000000007L; //if b is even
        if (b % 2 == 1) result = result * 1L * a % 1000000007L; // if b is odd
        return (int) result;
    }

}
