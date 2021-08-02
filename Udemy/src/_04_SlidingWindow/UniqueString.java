package _04_SlidingWindow;

import java.util.HashMap;

public class UniqueString {

  public static void main(String[] args) {
    String str = "aabcb";
    int[] indices = maxLenUnique(str.toCharArray());
    System.out.println(str.substring(indices[0], indices[1] + 1));

    str = "abcaeba";
    indices = maxLenUnique(str.toCharArray());
    System.out.println(str.substring(indices[0], indices[1] + 1));

    str = "prateekbhaiya";
    indices = maxLenUnique(str.toCharArray());
    System.out.println(str.substring(indices[0], indices[1] + 1));

  }

  // O(N) | O(N + 26)
  static int[] maxLenUnique(char[] charArray) {
    int left = 0;
    int right = 0;
    int maxLen = 0;
    int[] indices = new int[]{-1, -1};

    HashMap<Character, Integer> hash = new HashMap<>();

    while (right < charArray.length) {
      int[] freq = new int[26];

      while (right < charArray.length && freq[charArray[right] - 'a'] == 0) {
        hash.put(charArray[right], right);
        freq[charArray[right] - 'a']++;
        right++;
      }

      if (right == charArray.length) break;

      // Store the Max Here
      if ((right - left) > maxLen) {
        maxLen = right - left;
        indices = new int[]{left, right - 1};
      }

      right = hash.get(charArray[right]) + 1;
      left = right;
    }

    System.out.println(maxLen);

    return indices;
  }
}
