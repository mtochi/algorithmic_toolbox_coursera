package Week3;

import java.util.Collections;
import java.util.stream.IntStream;
import java.util.Arrays;
import java.util.Scanner;


public class FractionalKnapsack {




    private static int selectMax(int[] values, int[] weights) {
        int i = -1;
        double max = 0;
        for(int j = 0; j < values.length; j++){

            if(weights[j] > 0 &&  ((double)values[j] / weights[j])> max){
                double temp = ((double)values[j] / weights[j]);
                max = temp;
                i = j;
            }
        }
        return i;
    }

    private static double knapSackFast(int capacity, int[] values, int[] weights){
        double totalValue = 0;
        if(capacity == 0)
            return totalValue;

        for(int i = 0; i < values.length; i++) {
            int index = selectMax(values, weights);

            int a = Math.min(weights[index], capacity);
            totalValue += a * ((double)values[index] / weights[index]);
            weights[index] -= a;
            capacity -= a;
        }

        return (double)Math.round(totalValue * 100000d) / 100000d;

    }
    private static double knapSackFastFast(int capacity, int[] values, int[] weights){
        double totalValue = 0;

        //first valuesPerUnit
        //then sort the three arrays...
        // At the time of sorting:
        //
        //While you swap the elements of ratio array you can also swap the elements of numerator and denominator array at the same time.

        double[] valuesPerUnit = new double[values.length];

        for(int i = 0; i < values.length; i++){
            valuesPerUnit[i] = (double)values[i] / weights[i];
        }

        //now should sort the three arrays
        //bubble sort
        for(int i = 0; i < valuesPerUnit.length - 1; i++){
            for(int j = 0; j < valuesPerUnit.length - 1; j++){

                if(valuesPerUnit[j] > valuesPerUnit[j + 1]){
                    //swap
                    double temp = valuesPerUnit[j];
                    int tempV = values[j];
                    int tempW = weights[j];
                    //swapping valuesPerUnit array
                    valuesPerUnit[j] = valuesPerUnit[j + 1];
                    valuesPerUnit[j + 1] = temp;
                    //swapping values array
                    values[j] = values[j + 1];
                    values[j + 1] = tempV;
                    //swapping weights array
                    weights[j] = weights[j + 1];
                    weights[j + 1] = tempW;

                }


            }
        }

        for(int i = values.length - 1; i >= 0; i--){
            //System.out.println("here");
            int temp = Math.min(weights[i], capacity);
            totalValue = totalValue + temp * (valuesPerUnit[i]);
            weights[i] = weights[i] - temp;
            capacity = capacity - temp;

        }



        return (double)Math.round(totalValue * 100000d) / 100000d;



    }

    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
            double totalValue = 0;
        int weightTillNow = 0;
        //int [] resultWeights = new int[values.length];
        if(capacity == 0)
            return totalValue;


        //first I have to sort the values and the weights accordingly
        int[] indexes = IntStream.range(0, values.length)
                .boxed()
                .sorted((i, j) -> Double.compare(values[i] / weights[i], values[j] / weights[j]))
                .mapToInt(i -> i)
                .toArray();
        double[] sortedValues = IntStream.of(indexes)
                .mapToDouble(i -> values[i])
                .toArray();
        double[] sortedWeights = IntStream.of(indexes)
                .mapToDouble(i -> weights[i])
                .toArray();

        //System.out.println(Arrays.toString(sortedValues));
        //System.out.println(Arrays.toString(sortedWeights));
        //I should just start from the end of the arrays.... because they're sorted in ascending order....

        for(int i = values.length - 1; i >= 0; i--){
            //System.out.println("here");
            double temp = Math.min(sortedWeights[i], capacity);
            totalValue = totalValue + temp * (sortedValues[i] / sortedWeights[i]);
            sortedWeights[i] = sortedWeights[i] - temp;
            capacity = capacity - (int)temp;

        }



        return (double)Math.round(totalValue * 100000d) / 100000d;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }

        //System.out.println(getOptimalValue(capacity, values, weights));
        //System.out.println(knapSackFast(capacity, values, weights));
        System.out.println(knapSackFastFast(capacity, values, weights));
        //System.out.println(knapSack(capacity, values, weights, n));
    }
}

