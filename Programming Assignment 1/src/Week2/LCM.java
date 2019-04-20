package Week2;

import java.util.*;

public class LCM {
    private static long lcm_naive(int a, int b) {
        for (long l = 2; l <= (long) a * b; ++l)
            if (l % a == 0 && l % b == 0)
                return l;

        return (long) a * b;
    }

    private static long lcm_naive2(int a, int b){
        long temp1 = (long)a, temp2 = (long)b;
        long result = 1l;

        long l = 2;
        while(l <= (long)a * b / 2){
            if (temp1 % l == 0 || temp2 % l == 0) {
                result *= l;
            }
            if(temp1 % l == 0){
                temp1 = temp1 / l;
            }

            if(temp2 % l == 0){
                temp2 = temp2 / l;
            }
            if(!(temp1 % l == 0 || temp2 % l == 0))
                l++;
            //System.out.println(l);
            if(temp1 == 1 && temp2 == 1)
                break;
        }


        return result;
    }

    private static int gcd_faster(int a, int b){
        //Euclidean algorithm
        if(b == 0)
            return a;
        int temp = a % b;
        return gcd_faster(b, temp);
    }

    private static long lcm_even_faster(int a, int b){
        long temp = (long)a * b;
        long temp2 = (long)gcd_faster(a, b);
        return temp / temp2;
    }



    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        System.out.println(lcm_naive(a, b));
        System.out.println(lcm_naive(a, b));
        System.out.println(lcm_even_faster(a, b));
    }
}

