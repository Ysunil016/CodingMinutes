package Array;

import java.util.Arrays;
import java.util.HashSet;

public class Pair {

  public static void main(String[] args) {
    int[] arr = {12, 32, 54, -23, 43, 54, 65, 76, -56};

    int[] res = findPair(arr, -79);
    System.out.println(res[0] + " " + res[1]);

    int[] res2 = findPair2(arr, -79);
    System.out.println(res2[0] + " " + res2[1]);

    int[] res3 = findPair3(arr, -79);
    System.out.println(res3[0] + " " + res3[1]);
  }

  // O(N^2) | O(1)
  private static int[] findPair(int[] arr, int target) {
    for (int i = 0; i < arr.length; i++) {
      for (int j = i + 1; j < arr.length; j++) {
        int currentSum = arr[i] + arr[j];
        if (currentSum == target) return new int[]{arr[j], arr[i]};
      }
    }
    return new int[]{-1, -1};
  }

  // O(NlgN + N) | O(1)
  private static int[] findPair2(int[] arr, int target) {
    Arrays.sort(arr);
    int left = 0;
    int right = arr.length - 1;
    while (left < right) {
      int currentSum = arr[left] + arr[right];
      if (currentSum == target) return new int[]{arr[left], arr[right]};
      if (currentSum < target)
        left++;
      else
        right--;
    }
    return new int[]{-1, -1};
  }

  // O(N) | O(N)
  private static int[] findPair3(int[] arr, int target) {
    HashSet<Integer> set = new HashSet<>();
    for (int i = 0; i < arr.length; i++) {
      int req = target - arr[i];
      if (set.contains(req)) return new int[]{req, arr[i]};
      set.add(arr[i]);
    }
    return new int[]{-1, -1};
  }
}
