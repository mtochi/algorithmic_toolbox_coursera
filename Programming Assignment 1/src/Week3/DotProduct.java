package Week3;

import java.math.BigInteger;
import java.util.*;

public class DotProduct {
    private static long maxDotProduct(int[] a, int[] b) {
        //write your code here
        long result = 0;
        for (int i = 0; i < a.length; i++) {
            result += a[i] * b[i];
        }
        return result;
    }

    private static BigInteger maxDotProductFast(int[] a, int[] b){
        Arrays.sort(a);
        Arrays.sort(b);
        BigInteger sum = new BigInteger("0");
        for(int i = 0; i < a.length; i++){
            BigInteger tmp = new BigInteger("" + a[i] + "");
            BigInteger tmp2 = new BigInteger("" + b[i] + "");
            //System.out.println(tmp.toString() + " " + tmp2);
            BigInteger result = tmp.multiply(tmp2);

            sum = sum.add(result);
            //System.out.println(result.toString() + " " + sum.toString());
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }
        //System.out.println(maxDotProduct(a, b));
        System.out.println(maxDotProductFast(a, b));
    }
}


