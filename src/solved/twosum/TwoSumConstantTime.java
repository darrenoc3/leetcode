package solved.twosum;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/** https://leetcode.com/problems/two-sum/ 07/05/2021 17:45 Accepted 1 ms 39.1 MB java */
public class TwoSumConstantTime {
  public static int[] twoSum(int[] nums, int target) {
    var seenMap = new HashMap<Integer, Integer>();
    for (int i = 0; i < nums.length; i++) {
      int factorToFind = target - nums[i];
      if (seenMap.containsKey(factorToFind) && seenMap.get(factorToFind) != i) {
        var indices = new int[2];
        indices[0] = (seenMap.get(factorToFind));
        indices[1] = i;
        return indices;
      }
      seenMap.put(nums[i], i);
    }
    return null;
  }

  @Test
  public void test1() {
    int[] input = {2, 7, 11, 15};
    int[] output = twoSum(input, 9);
    Arrays.sort(output);
    assertThat(output, equalTo(new int[] {0, 1}));
  }

  @Test
  public void test2() {
    int[] input = new int[] {3, 2, 4};
    int[] output = twoSum(input, 6);
    Arrays.sort(output);
    assertThat(output, equalTo(new int[] {1, 2}));
  }

  @Test
  public void test3() {
    int[] input = new int[] {3, 3};
    int[] output = twoSum(input, 6);
    Arrays.sort(output);
    assertThat(output, equalTo(new int[] {0, 1}));
  }

  @Test
  public void test4() {
    int[] input = new int[] {2, 5, 5, 11};
    int[] output = twoSum(input, 10);
    Arrays.sort(output);
    assertThat(output, equalTo(new int[] {1, 2}));
  }
}
