package _04_SlidingWindow;

public class StringWindow {
  public static void main(String[] args) {
//    String str = "hello_world";
    String str = "hello";
    String small = "oll";

    int[] res = minWindow(str.toCharArray(), small.toCharArray());
    System.out.println(str.substring(res[0], res[1]));
  }

  private static int[] minWindow(char[] str, char[] pattern) {
    int[] patternFreq = new int[256];
    for (char c : pattern) patternFreq[c]++;

    int[] stringFreq = new int[256];
    int count = 0;
    int start = 0;
    int minValue = Integer.MAX_VALUE;
    int windowSize = 0;
    int startIdx = 0;

    for (int i = 0; i < str.length; i++) {

      char ch = str[i];
      // Start Expanding
      stringFreq[ch]++;

      if (patternFreq[ch] != 0 && stringFreq[ch] <= patternFreq[ch])
        count++;

      // Start Contracting
      if (count == pattern.length) {

        while (patternFreq[str[start]] == 0 || stringFreq[str[start]] > patternFreq[str[start]]) {
          stringFreq[str[start]]--;
          start++;
        }

        windowSize = i - start + 1;
        if (windowSize < minValue) {
          minValue = windowSize;
          startIdx = start;
        }
      }

    }

    if (minValue == Integer.MAX_VALUE) return new int[]{-1, -1};
    System.out.println(minValue);

    return new int[]{startIdx, startIdx + minValue};
  }
}
