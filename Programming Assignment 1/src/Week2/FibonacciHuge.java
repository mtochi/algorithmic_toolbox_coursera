package Week2;
import java.util.*;
import java.math.BigInteger;

public class FibonacciHuge {

    private static long getFibonacciHugeNaive(long n, long m) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;

        for (long i = 2; i <= n; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = (tmp_previous + current) % m;
            //System.out.println(Long.toUnsignedString(previous) + " " + Long.toUnsignedString(current) + " " + Long.toUnsignedString(tmp_previous));

        }
        return current;

    }

    private static BigInteger getFibonacciHugeWorking(long n, long m){
        if (n <= 1)
            return BigInteger.valueOf(n);

        long first = 0L;
        long second = 1L;
        //System.out.print(first + " " + second + " ");
        long third;
        //find the length of the period
        long i = 2L;
        for(; i <= m*m; i++){

            third = (first + second) % m;
            //System.out.print(third + " ");
            first = second;
            second = third;
            if(first == 0 && second == 1)
                break;
        }

        //System.out.println();
        long length = i - 1;


        //then find the number...
        long result = n % length;
        //System.out.println(n + " % " + length + " = " + result);

        //long previous = 0L;
        BigInteger previous = new BigInteger("0");
        BigInteger current = new BigInteger("1");
        BigInteger m2 = new BigInteger("" + m + "");

        if(result == 0){
            return BigInteger.valueOf(0L);
        }
        if(result == 1){
            return BigInteger.valueOf(1L);
        }

        for(long j = 2L; j <= result; j++){
            BigInteger tmp_previous = new BigInteger("" + previous + "");
            previous = new BigInteger("0").add(current);
            if(j == 2){
               // current = current.add(BigInteger.ONE);
            }
            current = current.add(tmp_previous);
            //System.out.println(tmp_previous + " " + previous + " " + current);
            /*
            long tmp_previous = (previous);
            previous = current;
            current = (tmp_previous + current);
            System.out.println(Long.toUnsignedString(previous) + " " + Long.toUnsignedString(current) + " " + Long.toUnsignedString(tmp_previous) + " result: " + Long.toUnsignedString(current % m));
            */
        }
        //System.out.println(current.mod(m2));
        //System.out.println(Long.MAX_VALUE);
        return current.mod(m2);

    }

    private static long getFibonacciHugeFaster(long n, long m) {

        if (n <= 1)
            return n;

        long[] thePeriod = new long[(int)(m * m)];
        thePeriod[0] = 0;
        thePeriod[1] = 1;
        thePeriod[2] = 1;


        long previous = 1;
        long current  = 1;

        int i = 1;
        int j = 3;
        //System.out.println(thePeriod[i] + " " + thePeriod[i + 1]);
        while(true){
            if(thePeriod[i] == 0L && thePeriod[i + 1] == 1L)
                break;
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + previous;
            //thePeriod[i] = current % m;
            long temp = (current % (long)m);
            //System.out.println(temp);
            thePeriod[j] = (current % m);
            //System.out.println(thePeriod[j]);
            j++;
            i++;

        }
        //System.out.println(current);
        int length = 2;
        for(int l = 2; l <= thePeriod.length; l++){
            if(thePeriod[l] == 0L && thePeriod[l + 1] == 1L){
                //System.out.println(thePeriod[i]);
                break;
            }
            else
                length++;
        }

        System.out.println(Arrays.toString(thePeriod));
        //System.out.println("The length: " + length);
        //System.out.println(n % length);
        long temp = (n % (length));
        //System.out.println(thePeriod[(int)temp] + " " + temp);
        return thePeriod[(int)(n %length)];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();

        long m = scanner.nextLong();
        //System.out.println(getFibonacciHugeFaster(n, m));
        //System.out.println(getFibonacciHugeNaive(n, m));
        System.out.println(getFibonacciHugeWorking(n, m));
    }
}

