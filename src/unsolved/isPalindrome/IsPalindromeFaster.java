package unsolved.isPalindrome;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class IsPalindromeFaster {

  /**
   * https://leetcode.com/problems/palindrome-number/ Runtime: 7 ms, faster than 67.40% of Java
   * online submissions for Palindrome Number. Memory Usage: 38.1 MB, less than 82.87% of Java
   * online submissions for Palindrome Number.
   */
  public boolean isPalindrome(int x) {
    var xChars = Integer.toString(x).toCharArray();
    for (int i = 0; i < xChars.length; i++) {
      int toCompare = xChars[i];
      int opposite = xChars[xChars.length - i - 1];
      if (toCompare != opposite) {
        return false;
      }
    }
    return true;
  }

  @Test
  public void test1() {
    assertThat(isPalindrome(121), equalTo(true));
    assertThat(isPalindrome(-121), equalTo(false));
    assertThat(isPalindrome(10), equalTo(false));
    assertThat(isPalindrome(-101), equalTo(false));
  }
}
