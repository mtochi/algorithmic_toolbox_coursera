package Week3;

import java.util.*;

public class LargestNumber {

    private static boolean IsGreaterOrEqual(int digit, int maxDigit){

        //check if int of maxDigit.append(digit) is greater than digit.append(MaxDigit)
        String str = "" + digit + maxDigit;
        String str2 = "" + maxDigit + digit;

        if((Integer.parseInt(str) >= Integer.parseInt(str2))){
            return true;
        }return false;
    }
    private static String largestNumber(String[] a) {
        //write your code here
        int max;

        String result = "";
        for (int i = 0; i < a.length; i++) {
            max = 0;
            int c = 0;
            for(int j = 0; j < a.length; j++){
                int tempA = Integer.parseInt(a[j]);
                if(IsGreaterOrEqual(tempA, max)){
                    max = tempA;
                    c = j;
                }
            }
            result += max;
            a[c] = String.valueOf(0);

        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.next();
        }
        System.out.println(largestNumber(a));
    }
}


