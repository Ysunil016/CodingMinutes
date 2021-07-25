package _03_String.Excercise;

import java.util.ArrayList;
import java.util.Collections;

public class BiggestNumberString {
  public static void main(String[] args) {
    ArrayList<Integer> nums = new ArrayList<>() {{
      add(10);
      add(11);
      add(20);
      add(30);
      add(3);
    }};

    System.out.println(largest(nums));
  }

  private static String largest(ArrayList<Integer> nums) {
    StringBuilder result = new StringBuilder();

    Collections.sort(nums, (a, b) -> {
      int compare = b.toString().compareTo(a.toString());
      return compare;
    });

    for (Integer str : nums)
      result.append(str);

    return new String(result);
  }
}
