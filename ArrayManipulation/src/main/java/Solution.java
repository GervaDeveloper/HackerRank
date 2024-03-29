import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] queries) {
        long[] valuesArray = new long[n + 2];

        for (int i = 0; i < queries.length; i++) {
            processArray(valuesArray, queries[i]);
        }
        return maxArrayValue(valuesArray);
    }

    private static void processArray(long[] valuesArray, int[] query) {
        int lIndex   = query[0] - 1;
        int rIndex   = query[1] - 1;
        int sumValue = query[2];

        valuesArray[ lIndex ] += sumValue;
        valuesArray[ rIndex +1 ] -= sumValue;
    }

    private static long maxArrayValue(long[] valuesArray) {
        long maxValue = Long.MIN_VALUE;
        long sum = 0;
        for (int i = 0; i < valuesArray.length; i++) {
            sum += valuesArray[i];
            maxValue = Math.max(sum, maxValue);
        }

        return maxValue;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        long result = arrayManipulation(n, queries);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
