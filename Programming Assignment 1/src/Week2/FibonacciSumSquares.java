package Week2;

import java.util.*;

public class FibonacciSumSquares {
    private static long getFibonacciSumSquaresNaive(long n) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;
        long sum      = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
            sum += current * current;
        }

        return sum % 10;
    }

    private static long getFibonacciSumSquaresFast(long n){
        if(n <= 1)
            return n;
        int first = 0, second = 1, third;

        int[] thePeriod = new int[60];
        thePeriod[0] = 0;
        thePeriod[1] = 1;
        long sum = 0L;

        for(int i = 2; i < 60; i++){
            third = ((first + second) % 10);
            thePeriod[i] = (third * third) % 10;
            first = second;
            second = third;
            //sum += thePeriod[i];
        }

        long times = n / 60;
        long modCalc = n % 60;
        sum += times * 280;
        //System.out.println(Arrays.toString(thePeriod));
        for(int i = 0; i <= modCalc; i++){
            sum += thePeriod[i];
        }

        //so get n and then try to see
        return sum % 10;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();

        //System.out.println(getFibonacciSumSquaresNaive(n));
        System.out.println(getFibonacciSumSquaresFast(n));

    }
}


