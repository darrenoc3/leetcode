package random;

import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

// Create deterministic mock of java.util.Random
class DeterministicRandom extends Random {
	private float fixedFloat = 0.0f;
	public DeterministicRandom(float f) {
		super();
		// float should be between 0.0 and 1.0
		assert f <= 1.0; 
		assert f >= 0.0;
		fixedFloat = f;
	}
	public float nextFloat() {
		return fixedFloat;
	}
}

class RandomGeneratorTest {

	/**
	 * Test that our mock for java.util.Random correctly returns a fixed value
	 */
	@Test
	void testDeterministicRandom() {
		DeterministicRandom dr = new DeterministicRandom(0.5f);
		// Check that DeterministicRandom extends java.util.Random
		Assertions.assertTrue(dr instanceof Random);
		Assertions.assertEquals(dr.nextFloat(), 0.5f);
	}
	
	/**
	 * Test that RandomGenerator rejects inputs where the number of random numbers
	 * does not match the number of probabilities
	 */
	@Test
	void testRandomGenerator_Should_ThrowException_When_WrongNumberOfInputs() {		
		boolean exceptionThrown = false;
		try {
		 int[] randomNums = {-1};
		 float[] probabilityBuckets = {0.5f, 0.5f};
		 new RandomGenerator(randomNums, probabilityBuckets, new Random());
		} catch(IllegalArgumentException e) {
			exceptionThrown = true;
		}
		if(!exceptionThrown) {
			Assertions.fail("Expected IllegalArgumentException was not thrown for wrong number of inputs");
		}
	}
	
	/**
	 * Test that RandomGenerator rejects inputs when the input probabilities to not
	 * sum to 1.0f
	 */
	@Test
	void testRandomGenerator_Should_ThrowException_When_ProbabilitiesDontAddUp() {		
		boolean exceptionThrown = false;
		try {
			 int[] randomNums = {-1, 2};
			 float[] probabilityBuckets = {0.2f, 0.5f};
			 new RandomGenerator(randomNums, probabilityBuckets, new Random());
		} catch(IllegalArgumentException e) {
			exceptionThrown = true;
		}
		if(!exceptionThrown) {
			Assertions.fail("Expected IllegalArgumentException was not thrown when sum of probabilities "
					+ "was <1.0");
		}
	}

	/**
	 * Test that RandomGenerator returns the correct random number when seeded with 
	 * specific random values to use for probability calculation.
	 * 
	 * Statistical testing of the distribution of results is out of scope for these
	 * unit tests, and we rely on the injection of our DeterministicRandom mock to
	 * make our test results accurate and repeatable.
	 */
	@Test
	void testNextNum() {
		 int[] randomNums = {-1, 0, 1, 2, 3};
		 float[] probabilityBuckets = {0.01f, 0.3f, 0.58f, 0.1f, 0.01f};
		 // Random values should be mapped to buckets as follows:
		 // 0.0f - 0.01f : -1
		 // 0.01f - 0.31f: 0
		 // 0.31f - 0.89f: 1
		 // 0.89f - 0.99f: 2
		 // 0.99f - 1.0f: 3
		 
		 // Seed the random generator with the specific value that should result in
		 // the specific number being returned based on the given probability 
		 // e.g. 0.005f should return -1, because 0.005f < 0.01f, putting it in the first 'bucket'
		 DeterministicRandom dr = new DeterministicRandom(0.005f);
		 RandomGenerator r = new RandomGenerator(randomNums, probabilityBuckets, dr);
		 Assertions.assertEquals(randomNums[0], r.nextNum());
		 
		 dr = new DeterministicRandom(0.01f);
		 r = new RandomGenerator(randomNums, probabilityBuckets, dr);
		 Assertions.assertEquals(randomNums[1], r.nextNum());
		 
		 dr = new DeterministicRandom(0.999f);
		 r = new RandomGenerator(randomNums, probabilityBuckets, dr);
		 Assertions.assertEquals(randomNums[4], r.nextNum());
	}

}
