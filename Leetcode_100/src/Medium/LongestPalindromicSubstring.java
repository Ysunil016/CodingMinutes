package Medium;

public class LongestPalindromicSubstring {

  public static void main(String[] args) {
    args = new String[]{"au", "abcabcbb", "bbbbb", "pwwkew", "", "aa", "aba", "babac", " ", "  ",};
    for (String str : args)
      System.out.println(str + " -> " + longestPalindrome(str));

  }

  static String longestPalindrome(String str) {
    if(str.length() == 0) return "";

    int start = 0;
    int end = 0;
    for (int i = 0; i < str.length(); i++) {
      int maxOdd = extend(str, i, i);
      int maxEven = extend(str, i, i + 1);
      int len = Math.max(maxEven, maxOdd);

      if (len > end - start + 1) {
        start = i - (len - 1) / 2;
        end = i + len / 2;
      }
    }

    return str.substring(start, end + 1);
  }

  static int extend(String str, int left, int right) {
    int L = left;
    int R = right;

    while (L > 0 && R < str.length() && str.charAt(L) == str.charAt(R)) {
      L--;
      R++;
    }

    return R - L - 1;
  }
}
