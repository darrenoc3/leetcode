package solved;
import java.io.IOException;

public class Hourglass {

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
    	int currentMaxSum = Integer.MIN_VALUE;
        for(int x = 0; x < arr.length-2; x++) {
            for(int y = 0; y < arr[x].length-2; y++) {
                //System.out.print(arr[x][y]);
                // hourglass is of the form
                // a b c 
                // * d *
                // e f g
                int currentSum = 
                	      arr[y]  [x] +    // a
                		  arr[y]  [x+1] +    // b
                		  arr[y]  [x+2] +  // c
                		  arr[y+1][x+1] +  // d
                		  arr[y+2][x] +  // e
                		  arr[y+2][x+1] +  // f 
                		  arr[y+2][x+2];   // g
                
  
                
                System.out.println("sum for " +x +"," +y +" is " +currentSum);
                currentMaxSum = Math.max(currentMaxSum, currentSum);
            }
            System.out.println();
        }
        return currentMaxSum;
    }

    public static void main(String[] args) throws IOException {
    	/*
        int[][] arr = { {1, 1, 1, 0, 0, 0},
        				{0, 1, 0, 0, 0, 0},
    					{1, 1, 1, 0, 0, 0},
						{0, 0, 2, 4, 4, 0},
						{0, 0, 0, 2, 0, 0},
						{0, 0, 1, 2, 4, 0}
        }; */
    	
    	int[][] arr = { {-1, -1, 0, -9, -2, -2},
    					{-2, -1, -6, -8, -2, -5},
    					{-1, -1, -1, -2, -3, -4},
    					{-1, -9, -2, -4, -4, -5},
    					{-7, -3, -3, -2, -9, -9},
    					{-1, -3, -1, -2, -4, -5}
    	};

        int result = hourglassSum(arr);
        System.out.println("answer is " +result);
    }
}
