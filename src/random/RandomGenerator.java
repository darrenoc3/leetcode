package random;

import java.util.Random;

public class RandomGenerator {
 // Values that may be returned by nextNum()
 private int[] randomNums;
 // Probability of the occurence of randomNums, divided into buckets
 private float[] probabilityBuckets;
 // Random generator
 Random rand;
 RandomGenerator(int[] randomNums, float[] probabilities, Random rand) {
	 if(randomNums.length != probabilities.length) {
		 throw new IllegalArgumentException("Number of random numbers must"
		 		+ " match the number of associated probabilities");
	 }
	 this.randomNums = randomNums;
	 this.rand = rand;
	 // Bucket the probabilities from 0-1 via a cumulative summation
	 probabilityBuckets = new float[probabilities.length];
	 float totalProb = 0;
	 for(int i = 0; i < probabilities.length; i++) {
		 probabilityBuckets[i] = probabilities[i] + totalProb;
		 totalProb += probabilities[i];
	 }
	 if(totalProb != 1) {
		 throw new IllegalArgumentException("Probabilites must sum to 1.0"); 
	 }
 }
 /**
 Returns one of the randomNums. When this method is called
 multiple times over a long period, it should return the
 numbers roughly with the initialized probabilities.
 
 Example, given the following initialization:
	random numbers = [1 , 2]
	probabilities = [0.5f, 0.5f]
 Generates a random value R
 Returns '1' when R is between 0.0f - 0.49f
 Returns '2' when R is between 0.5f - 1.0f
**/
 public int nextNum() {
	 // Obtain a random float between 0 and 1.0
	 float random = rand.nextFloat();
	 // Perform a binary search to find the right bucket
	 int low = 0;
	 int mid = 0;
	 int high = probabilityBuckets.length - 1;
	 while(low <= high) {
		 mid = (high + low) / 2;
		 if(random < probabilityBuckets[mid]) {
			 high = mid - 1;
		 } else if(random >= probabilityBuckets[mid]) {
			 low = mid + 1;
		 } 
	 }
	 // Return the number that corresponds to the correct probability bucket
	 return randomNums[mid];
 }
}