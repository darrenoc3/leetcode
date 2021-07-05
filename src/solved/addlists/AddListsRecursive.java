package solved.addlists;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class AddListsRecursive {

  // *** solution not working ***
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
    ListNode result = new ListNode(0);
    addTwoNumbers(result, 0, l1, l2);
    return result;
  }

  public static ListNode addTwoNumbers(ListNode result, int oneCarried, ListNode l1, ListNode l2) {
    int total = l1.val + l2.val + oneCarried;
    int carryOneForward = 0;
    if (total > 9) {
      result.val = 0;
      carryOneForward = 1;
    } else {
      result.val = total;
    }

    result.next = new ListNode(0);
    if (l1.next == null && l2.next == null) {
      return result;
    }
    return addTwoNumbers(result.next, carryOneForward, l1.next, l2.next);
  }

  @Test
  public void test1() {
    ListNode left = new ListNode(2);
    left.next = new ListNode(4);
    left.next.next = new ListNode(3);

    ListNode right = new ListNode(5);
    right.next = new ListNode(6);
    right.next.next = new ListNode(4);

    ListNode result = addTwoNumbers(left, right);

    ListNode expected = new ListNode(7);
    expected.next = new ListNode(0);
    expected.next.next = new ListNode(8);

    assertThat(result, equalTo(expected));
  }
}
