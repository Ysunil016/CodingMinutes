package Medium;

public class LongestSubStringWithoutRepeat {

  public static void main(String[] args) {
    String[] strings = {"au", "abcabcbb", "bbbbb", "pwwkew", "", "aa", "aba", "babac", " ", "  ",};
    for (String str : strings)
      System.out.println(str + " -> " + lengthOfLongestSubstring(str));
  }

  static int lengthOfLongestSubstring(String s) {
    int counter = 0;

    int max = 0;

    while (counter < s.length()) {
      int[] freq = new int[256];

      freq[s.charAt(counter)]++;
      int localMax = 1;

      int left = counter - 1;
      int right = counter + 1;

      while (left > 0 && freq[s.charAt(left)] == 0) {
        freq[s.charAt(left)]++;
        localMax++;
        left--;
      }
      while (right < s.length() && freq[s.charAt(right)] == 0) {
        freq[s.charAt(right)]++;
        localMax++;
        right++;
      }

      counter = right + 1;

      max = Math.max(max, localMax);
    }
    return max;
  }
}
