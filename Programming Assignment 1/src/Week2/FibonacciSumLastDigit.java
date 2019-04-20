package Week2;
import java.util.*;

public class FibonacciSumLastDigit {
    private static long getFibonacciSumNaive(long n) {

        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;
        long sum      = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
            sum += current;

        }
        return sum % 10;
    }




    private static long getFibonacciSumFast(long n) {
        //length of period with Fi mod 10 ==> 60
        if(n <= 1){
            return n;
        }
        long first = 0L;
        long second  = 1L;

        long third;

        int [] thePeriod = new int[60];
        thePeriod[0] = 0;
        thePeriod[1] = 1;

        long sum = 1L;
        //can do some more optimization....
        for(int i = 2; i < 60; i++){
            third = (int)((first + second) % 10);
            thePeriod[i] = (int)third;
            first = second;
            second = third;
            sum += third;
        }
        long times = n / 60;
        long calcMod = n % 60;
        long result = times * sum;


        for(int i = 0; i <= calcMod; i++){
            result += thePeriod[i];
        }

        return result % 10;
    }

        public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();

        //System.out.println(getFibonacciSumNaive(n));
        System.out.println(getFibonacciSumFast(n));
    }
}

