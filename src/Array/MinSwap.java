package Array;

import java.util.Arrays;
import java.util.HashMap;

public class MinSwap {
  public static void main(String[] args) {
    int[] arr = new int[]{5, 4, 3, 2, 1};
    System.out.println(minSwap(arr));

    arr = new int[]{10, 11, 5, 4, 3, 2, 1};
    System.out.println(minSwap(arr));

    arr = new int[]{2, 4, 5, 1, 3};
    System.out.println(minSwap(arr));
  }

  // O(NLgN + N) | O(N)
  static int minSwap(int[] arr) {
    HashMap<Integer, Integer> hash = new HashMap<>();
    for (int i = 0; i < arr.length; i++) hash.put(arr[i], i);
    int[] original = arr.clone();
    Arrays.sort(arr);

    boolean[] isVisited = new boolean[arr.length];
    int minSwap = 0;

    for (int i = 0; i < arr.length; i++) {
      if (isVisited[i] || original[i] == arr[i]) continue;

      int cycleCount = 0;
      int idx = i;
      while (!isVisited[idx]) {
        cycleCount++;
        isVisited[idx] = true;
        idx = hash.get(arr[idx]);
      }
      minSwap += cycleCount - 1;
    }

    return minSwap;
  }
}
