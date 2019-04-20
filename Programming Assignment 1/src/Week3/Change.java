package Week3;

import java.util.Scanner;

public class Change {
    private static int getChange(int m) {
        //write your code here
        int valueTillNow = 0;
        int[] array = new int[]{10, 5, 1};
        int count = 0;
        int i = 0 ;
        while(valueTillNow <= m){
            //System.out.println("array[i]" + array[i]);
            if(valueTillNow + array[i] <= m){
                valueTillNow = valueTillNow + array[i];
                //System.out.println(valueTillNow);
                count++;
            }else{
                i++;
                if(i > 2){
                    break;
                }
            }
        }

        //System.out.println(valueTillNow);
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

