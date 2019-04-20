
import java.util.*;
import java.io.*;

public class MaxPairwiseProduct {

    static void stressTest(int nLength, int max){
        nLength = (int)(Math.random() * max) + 2;
        //System.out.println(nLength);
        int[] numbers = new int[nLength];

        for(int i = 0; i < nLength; i++){
            numbers[i] = (int)(Math.random() * max) + 0;
        }

        System.out.println(Arrays.toString(numbers));

        long result1 = getMaxPairwiseNaive(numbers);
        long result2 = getMaxPairWiseProductEvenFaster(numbers);

        if(result1 == result2){
            System.out.println("OK");
        }else{
            System.out.println("Wrong answer: " + result1 + "  " + result2);

        }
    }

    static long getMaxPairwiseNaive(int [] numbers){
        long product = 0L;
        int n = numbers.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                product = Math.max((long)product, (long) numbers[i] * numbers[j]);
                //System.out.println("i: " + i + "product: " + product);
            }
        }
        return product;
    }
    static long getMaxPairwiseProductFast(int[] numbers) {
        long product2;
        int n = numbers.length;

        int index1 = 0;
        //A faster algorithm
        for(int i = 0; i < n; i++){
            if(numbers[i] > numbers[index1])
                index1 = i;
        }
        int index2;
        if(index1 == 0){
            index2 = 1;
        }else{
            index2 = 0;
        }
        for(int i = 0; i < n; i++){
            if(i != index1 && numbers[i] > numbers[index2])
                index2 = i;
        }

        //System.out.println("number1: " + numbers[index1] + "number2: " + numbers[index2]);
        product2 = (long)numbers[index1] * (long)numbers[index2];
        return product2;
    }

    static long getMaxPairWiseProductEvenFaster(int[] numbers){
        int n = numbers.length;
        int max1;
        int max2;
        if(numbers[0] >= numbers[1]){
            max1 = numbers[0];
            max2 = numbers[1];
        }else{
            max1 = numbers[1];
            max2 = numbers[0];
        }

        for(int i = 2; i < n;i ++){
            if(numbers[i] > max2){
                if(numbers[i] > max1){
                    if(max1 > max2){
                        max2 = max1;
                    }
                    max1 = numbers[i];
                }else{
                    max2 = numbers[i];
                }
            }
        }
        System.out.println(max1 + " " + max2);
        return (long)max1 * (long)max2;

    }


    public static void main(String[] args) {
        /*FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }*/
        //System.out.println(getMaxPairwiseProductFast(numbers));
        //System.out.println(getMaxPairWiseProductEvenFaster(numbers));
        stressTest(2000, 200000);
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

    }
}
