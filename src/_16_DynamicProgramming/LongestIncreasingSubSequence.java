package _16_DynamicProgramming;

import java.util.Arrays;
import java.util.HashMap;

public class LongestIncreasingSubSequence {

  public static void main(String[] args) {
    int[] arr = new int[]{50, 4, 10, 8, 30, 100, 150, 10, 600, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
    System.out.println(maxLen(arr, 0, Integer.MIN_VALUE));
    System.out.println();
    int[] mem = new int[arr.length + 1];
    System.out.println();
    Arrays.fill(mem, -1);
    System.out.println(maxLen2(arr, 0, -1));
  }

  // O(Exponential)
  private static int maxLen(int[] arr, int idx, int prevElement) {
    if (idx == arr.length) return 0;

    int maxValue;
    if (arr[idx] > prevElement) {
      maxValue = Math.max(1 + maxLen(arr, idx + 1, arr[idx]), maxLen(arr, idx + 1, prevElement));
    } else
      maxValue = maxLen(arr, idx + 1, prevElement);

    return maxValue;
  }

  static HashMap<String, Integer> hash = new HashMap<>();

  // O(Linear)
  private static int maxLen2(int[] arr, int idx, int prevIndex) {
    if (idx == arr.length) return 0;


    String key = idx + "" + prevIndex;
    if (hash.containsKey(key)) return hash.get(key);

    int prevElement = Integer.MIN_VALUE;
    if (prevIndex != -1) prevElement = arr[prevIndex];

    int maxValue;
    if (arr[idx] > prevElement)
      maxValue = Math.max(1 + maxLen2(arr, idx + 1, idx), maxLen2(arr, idx + 1, prevIndex));
    else
      maxValue = maxLen2(arr, idx + 1, prevIndex);

    hash.put(key, maxValue);

    return maxValue;
  }

}
