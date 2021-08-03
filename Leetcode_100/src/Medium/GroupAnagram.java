package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagram {

  public static void main(String[] args) {
    String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
    for (List<String> x : groupAnagrams(strs)) {
      for (String y : x)
        System.out.print(y + " ");
      System.out.println();
    }
  }

  public static List<List<String>> groupAnagrams(String[] strs) {
    List<List<String>> result = new ArrayList<>();

    HashMap<String, List<String>> hash = new HashMap<>();
    for (String str : strs) {
      char[] cArray = str.toCharArray();
      Arrays.sort(cArray);
      String key = String.valueOf(cArray);
      if (hash.containsKey(key)) {
        hash.get(key).add(str);
      } else {
        List<String> value = new ArrayList();
        value.add(str);
        hash.put(key, value);
      }
    }

    for (String key : hash.keySet()) {
      result.add(hash.get(key));
    }

    return result;
  }
}
