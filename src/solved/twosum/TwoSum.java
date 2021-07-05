package solved.twosum;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/** https://leetcode.com/problems/two-sum/ 07/05/2021 17:33 Accepted 101 ms 39.4 MB java */
public class TwoSum {
  public static int[] twoSum(int[] nums, int target) {
    for (int i = 0; i < nums.length - 1; i++) {
      for (int x = 1; x < nums.length; x++) {
        if (i != x && nums[i] + nums[x] == target) {
          return new int[] {i, x};
        }
      }
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
