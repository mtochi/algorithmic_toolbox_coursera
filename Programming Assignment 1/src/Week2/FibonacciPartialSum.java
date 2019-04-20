package Week2;
import java.util.*;

public class FibonacciPartialSum {
    private static long getFibonacciPartialSumNaive(long from, long to) {
        long sum = 0;

        long current = 0;
        long next  = 1;

        for (long i = 0; i <= to; ++i) {
            if (i >= from) {
                sum += current;
            }

            long new_current = next;
            next = next + current;
            current = new_current;
        }
        System.out.println("SumNaive: " + sum);
        return sum % 10;
    }

    private static long calculateSumLastDigit(long n){
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

        return result;
    }

    private static long getFibonacciPartialSumSecond(long from, long to){
        long resultTo = calculateSumLastDigit(to);
        //System.out.println(resultTo);
        long resultFrom = calculateSumLastDigit(from - 1);
        //System.out.println(resultFrom);
        return (resultTo - resultFrom) % 10;


    }
    private static long getFibonacciPartialSumFast(long from, long to){
        //if to is less than 60 we'll just go through the pisano period and sum....
        //first calculate pisano period and store it into an array
        int[] thePeriod = new int[60];
        thePeriod[0] = 0;
        thePeriod[1] = 1;
        int first = 0;
        int second = 1;
        int third;
        for(int i = 2; i < 60; i++){
            third = (first + second) % 10;
            thePeriod[i] = third;
            first = second;
            second = third;
            //System.out.println(thePeriod[i])
        }
        System.out.println(Arrays.toString(thePeriod));
        //pisano period is in the array...

        if(from == to){ //should also be checked....

        }

        if(to < 60){ //that also means that from is less than 60...

        }else{ //else if to is greater than 60, then ...
            int fromThis = (int)(from % 60);
            int result = 0;
            //we should calculate pisano from 10 to the first 60...
            for(int i = fromThis; i < 60; i++){
                result += thePeriod[i];
            }

            //now we should calculate how many times *

            //
            System.out.println(fromThis + " result: " + result);

        }


        return 0L;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long from = scanner.nextLong();
        long to = scanner.nextLong();
        //System.out.println("Naive: " + getFibonacciPartialSumNaive(from, to));
        System.out.println(getFibonacciPartialSumSecond(from, to));
    }
}

