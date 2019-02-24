package solved;

import java.io.IOException;

public class SimpleArraySum {

  static int simpleArraySum(int[] ar) {
    int sum = 0;
    for (int i : ar) {
      sum += i;
    }
    return sum;
  }

  public static void main(String[] args) throws IOException {
    System.out.println(simpleArraySum(new int[]{1, 2, 3, 4, 10, 11}));
  }
}
