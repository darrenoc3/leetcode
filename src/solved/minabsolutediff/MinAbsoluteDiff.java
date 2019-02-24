package solved.minabsolutediff;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class MinAbsoluteDiff {

    // O(n) implementation
    static int minimumAbsoluteDifference(int[] arr) {
    	Arrays.sort(arr);
    	int minAbsDiff = Integer.MAX_VALUE;
    	for(int i = 0; i < arr.length-1; i++) {
    		int absDiff = Math.abs(arr[i] - arr[i+1]);
			if(absDiff < minAbsDiff) {
				minAbsDiff = absDiff;
			}
		}
    	return minAbsDiff;
    }
    
    // first naive O(n)2 implementation
    static int minimumAbsoluteDifferenceSlow(int[] arr) {
    	Arrays.sort(arr);
    	int minAbsDiff = Integer.MAX_VALUE;
    	for(int i = 0; i < arr.length; i++) {
    		for(int j = 0; j < arr.length; j++) {
    			if(i != j) {
    				int absDiff = Math.abs(arr[i] - arr[j]);
    				if(absDiff < minAbsDiff) {
    					minAbsDiff = absDiff;
    				}
    			}
    		}
    	}
    	return minAbsDiff;
    }


    public static void main(String[] args) throws IOException {
    	File file = new File("C:\\Users\\darre_000\\eclipse-workspace\\HackerRank\\unsolved\\MinAbsoluteDiff\\input02.txt");
    	Scanner scanner = new Scanner(file);

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = minimumAbsoluteDifference(arr);
        System.out.println(result);
        scanner.close();
    }
}
