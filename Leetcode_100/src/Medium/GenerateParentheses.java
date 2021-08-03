package Medium;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

  public static void main(String[] args) {
    int len = 2;
    List<String> result = new ArrayList<>();
    generate(len, len, "", result);
    for (String str : result) {
      System.out.println(str);
    }
  }

  private static void generate(int open, int close, String str, List<String> result) {
    if (open > 0) {
      String currentStr = str + "(";
      generate(open - 1, close, currentStr, result);
    }
    if (close > open) {
      String currentStr = str + ")";
      generate(open, close - 1, currentStr, result);
    }
    if (close == 0) result.add(str);
  }


}
