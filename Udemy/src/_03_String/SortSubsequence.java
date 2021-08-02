package _03_String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortSubsequence {
  public static void main(String[] args) {
    String str = "qwerty";

    char[] arr = str.toCharArray();
    Arrays.sort(arr);
    str = String.valueOf(arr);

    List<String> res = new ArrayList<>();
    subset(str, 0, "", res);

    for (String s : res)
      System.out.println(s);
  }

  private static void subset(String s, int idx, String res, List<String> result) {
    if (idx >= s.length()) {
      result.add(res);
      return;
    }
    subset(s, idx + 1, res, result);
    subset(s, idx + 1, res + s.charAt(idx), result);
  }
}
