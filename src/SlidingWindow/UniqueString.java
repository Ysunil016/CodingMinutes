package SlidingWindow;

public class UniqueString {

  public static void main(String[] args) {
//    String str = "aabcb";
    String str = "prateekbhaiya";
    int[] indices = maxLenUnique(str.toCharArray());
    System.out.println(str.substring(indices[0], indices[1] + 1));
  }

  static int[] maxLenUnique(char[] charArray) {
    int left = 0;
    int right = 0;
    int maxLen = 0;
    int[] indices = new int[]{-1, -1};

    while (right < charArray.length) {
      int[] freq = new int[26];

      while (freq[charArray[right] - 'a'] == 0) {
        freq[charArray[right] - 'a']++;
        right++;
      }

      // Store the Max Here
      if ((right - left) > maxLen) {
        maxLen = right - left;
        indices = new int[]{left, right - 1};
      }

      left = right;
      right++;
    }

    System.out.println(maxLen);

    return indices;
  }
}
