package solved;
import java.util.Scanner;

public class BubbleSort {

    // Complete the countSwaps function below.
    static void countSwaps(int[] a) {
    	int numSwaps = 0;
    	for (int i = 0; i < a.length; i++) {
    	    for (int j = 0; j < a.length - 1; j++) {
    	        // Swap adjacent elements if they are in decreasing order
    	        if (a[j] > a[j + 1]) {
    	        	// swap
    	        	int left = a[j];
    	        	int right = a[j+1];
    	        	a[j] = right;
    	        	a[j+1] = left;
    	        	numSwaps++;
    	        }
    	    }
    	    
    	}
    	System.out.println("Array is sorted in " +numSwaps +" swaps.");
    	System.out.println("First Element: " +a[0]);
    	System.out.println("Last Element: " +a[a.length-1]);
    }
    

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        countSwaps(new int[]{3, 2, 1});

        scanner.close();
    }
}
