package Week2;
import java.util.Scanner;

public class Fibonacci {
    private static long calc_fib(int n) {
        if (n <= 1)
            return n;

        return calc_fib(n - 1) + calc_fib(n - 2);
    }

    private static long calc_fib_iterative(int n) {
        long[] theArray = new long[n + 2];
        theArray[0] = 0;
        theArray[1] = 1;

        for(int i = 2; i <= n; i++){
            theArray[i] = theArray[i-1] + theArray[i - 2];
            //System.out.println("i: " + i + " number: " + theArray[i]);
        }

        return theArray[n];
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        //System.out.println(calc_fib(n));
        System.out.println(calc_fib_iterative(n));
    }
}
