package solved.addlists;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class AddListsIterative {

  /**
   * https://leetcode.com/problems/add-two-numbers/ Runtime: 2 ms, faster than 69.71% of Java online
   * submissions for Add Two Numbers. Memory Usage: 39.5 MB, less than 37.68% of Java online
   * submissions for Add Two Numbers.
   */
  static class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }

    @Override
    public String toString() {
      if (next != null) {
        return val + next.toString();
      } else return Integer.toString(val);
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      return this.toString().equals(o.toString());
    }
  }

  public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode resultRoot = new ListNode(-1);
    ListNode resultNode = resultRoot;
    int oneCarried = 0;
    while (l1 != null || l2 != null) {
      int sum = 0;
      if (l1 != null) {
        sum += l1.val;
        l1 = l1.next;
      }
      if (l2 != null) {
        sum += l2.val;
        l2 = l2.next;
      }
      sum += oneCarried;
      if (sum >= 10) {
        sum = sum - 10;
        oneCarried = 1;
      } else {
        oneCarried = 0;
      }
      if (resultNode.val == -1) {
        resultRoot.val = sum;
      } else {
        resultNode.next = new ListNode(sum);
        resultNode = resultNode.next;
      }
      if ((l1 == null && l2 == null) && oneCarried != 0) {
        // add trailing one
        resultNode.next = new ListNode(1);
        resultNode = resultNode.next;
      }
    }
    return resultRoot;
  }

  @Test
  public void test1() {
    ListNode left = createLinkedListFromDigits(2, 4, 3);
    ListNode right = createLinkedListFromDigits(5, 6, 4);
    ListNode result = addTwoNumbers(left, right);
    ListNode expected = createLinkedListFromDigits(7, 0, 8);
    assertThat(result, equalTo(expected));
  }

  @Test
  public void test2() {
    ListNode left = new ListNode(0);
    ListNode right = new ListNode(0);
    ListNode result = addTwoNumbers(left, right);
    ListNode expected = new ListNode(0);
    assertThat(result, equalTo(expected));
  }

  @Test
  public void test3() {
    ListNode left = createLinkedListFromDigits(9, 9, 9, 9, 9, 9, 9);
    ListNode right = createLinkedListFromDigits(9, 9, 9, 9);
    ListNode result = addTwoNumbers(left, right);
    ListNode expected = createLinkedListFromDigits(8, 9, 9, 9, 0, 0, 0, 1);
    assertThat(result, equalTo(expected));
  }

  private ListNode createLinkedListFromDigits(int... digits) {
    ListNode listRoot = new ListNode(-1);
    ListNode listPointer = listRoot;
    for (int i = 0; i < digits.length; i++) {
      listPointer.val = digits[i];
      if (i + 1 < digits.length) {
        listPointer.next = new ListNode(-1);
        listPointer = listPointer.next;
      }
    }
    return listRoot;
  }
}
