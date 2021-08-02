package _03_String;

import java.util.ArrayList;
import java.util.List;

public class Tokenization {
  public static void main(String[] args) {
    String str = "hello world i am doing very good  here 2 ";
    List<String> res = tokenize(str);
    for (String s : res) {
      System.out.println(s);
    }
  }

  // O(N) | O(N)
  static List<String> tokenize(String str) {
    StringBuilder strBuild = new StringBuilder();
    List<String> res = new ArrayList<>();

    char delimiters = ' ';

    for (char c : str.toCharArray()) {
      if (c == delimiters) {
        res.add(new String(strBuild));
        strBuild.delete(0, str.length() - 1);
      } else {
        strBuild.append(c);
      }
    }
    res.add(new String(strBuild));
    return res;
  }
}
