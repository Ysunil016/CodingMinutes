package Hard;

import java.util.HashSet;

public class FirstMissingPositive {
  public static void main(String[] args) {
    System.out.println(firstMissingPositive(new int[]{1, 2, 4, -5, 6, 7, 8, 5, 3, 10}));
  }

  public static int firstMissingPositive(int[] nums) {
    HashSet<Integer> set = new HashSet<>();
    for (int x : nums) set.add(x);

    int smallestPositive = 1;

    while (set.contains(smallestPositive)) {
      smallestPositive++;
    }

    return smallestPositive;
  }
}
