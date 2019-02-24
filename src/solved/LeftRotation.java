package solved;
import java.io.IOException;

public class LeftRotation {

    // Complete the rotLeft function below.
    static int[] rotLeft(int[] a, int rotations) {
    	int[] rotated = a.clone();
      	for(int i = 0; i < a.length; i++) {
        	int newIndex = i - rotations;
        	if(newIndex < 0) {
        		newIndex = a.length + newIndex;
        	}
        	rotated[newIndex] = a[i];
    	}
    	return rotated;	
    }
   
    

    public static void main(String[] args) throws IOException {

    	int[] a = {1, 2, 3, 4, 5};
    	int d = 4;
        int[] result = rotLeft(a, d);
        System.out.println("rotated: " +java.util.Arrays.toString(result));

    }
}
