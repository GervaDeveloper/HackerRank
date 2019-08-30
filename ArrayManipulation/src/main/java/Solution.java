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
    	int lIndex, rIndex, sumValue, maxValue = 0;
    	
    	int[] valuesArray = new int[n];
    	Arrays.fill(valuesArray, 0);

    	for (int i = 0; i < queries.length; i++) {
    		lIndex   = queries[i][0];
    		rIndex   = queries[i][1];
    		sumValue = queries[i][2];
    		
    		for (int j = lIndex; j < rIndex; j++) {
    			valuesArray[j] = valuesArray[j] + sumValue;
			}
		}
    	
    	for (int i = 0; i < valuesArray.length; i++) {
			if (valuesArray[i] > maxValue) {
				maxValue = valuesArray[i];
			}
		}
    	System.out.println(maxValue);
		return maxValue;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
    	//System.getenv("OUTPUT_PATH");
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/output"));

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
