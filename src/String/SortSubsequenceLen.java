package String;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortSubsequenceLen {
  public static void main(String[] args) {
    String str = "abcd";
    List<String> res = subset(str);
    for (String s : res)
      System.out.println(s);
  }

  // O(n^2)
  private static List<String> subset(String str) {
    List<String> res = new ArrayList<>();
    res.add("");
    for (char c : str.toCharArray()) {
      List<String> newGroup = new ArrayList<>();
      for (String el : res) {
        newGroup.add(el + c);
      }
      res.addAll(newGroup);
    }

    Collections.sort(res, (A, B) -> {
      int aLn = A.length();
      int bLn = B.length();
      if (aLn != bLn) return A.length() - B.length();
      else return A.compareTo(B);
    });

    return res;
  }
}
