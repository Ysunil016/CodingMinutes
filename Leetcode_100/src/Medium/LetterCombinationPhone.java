package Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinationPhone {

  public static void main(String[] args) {
    for (String str : letterCombinations("435167543"))
      System.out.println(str);
  }

  static HashMap<Character, List<Character>> hash = new HashMap<>() {{
    put('1', List.of('1'));
    put('2', List.of('a', 'b', 'c'));
    put('3', List.of('d', 'e', 'f'));
    put('4', List.of('g', 'h', 'i'));
    put('5', List.of('j', 'k', 'l'));
    put('6', List.of('m', 'n', 'o'));
    put('7', List.of('p', 'q', 'r', 's'));
    put('8', List.of('t', 'u', 'v'));
    put('9', List.of('w', 'x', 'y', 'z'));
  }};

  public static List<String> letterCombinations(String digits) {
    List<String> result = new ArrayList<>();
    dfs(digits, 0, result, "");
    return result;
  }

  private static void dfs(String digit, int idx, List<String> result, String res) {
    if (idx == digit.length() && res.length() != 0) {
      result.add(res);
      return;
    }

    if (idx >= digit.length()) return;

    char cChar = digit.charAt(idx);
    List<Character> nbr = hash.get(cChar);
    for (char x : nbr) {
      dfs(digit, idx + 1, result, res + x);
    }
  }
}
