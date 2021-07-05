package unsolved.isPalindrome;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class IsPalindrome {

  /**
   * https://leetcode.com/problems/palindrome-number/ Runtime: 23 ms, faster than 7.81% of Java
   * online submissions for Palindrome Number. Memory Usage: 39.4 MB, less than 16.71% of Java
   * online submissions for Palindrome Number.
   */
  public boolean isPalindrome(int x) {
    String xStr = Integer.toString(x);
    String xReversed = "";
    for (char c : xStr.toCharArray()) {
      xReversed = c + xReversed;
    }
    return xReversed.equals(xStr);
  }

  @Test
  public void test1() {
    assertThat(isPalindrome(121), equalTo(true));
    assertThat(isPalindrome(-121), equalTo(false));
    assertThat(isPalindrome(10), equalTo(false));
    assertThat(isPalindrome(-101), equalTo(false));
  }
}
