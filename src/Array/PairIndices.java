package Array;

import java.util.HashMap;

public class PairIndices {

  public static void main(String[] args) {
    int[] arr = {12, 32, 54, -23, 43, 54, 65, 76, -56};

    int[] res = findPair(arr, -79);
    System.out.println(res[0] + " " + res[1]);

    int[] res2 = findPair3(arr, -79);
    System.out.println(res2[0] + " " + res2[1]);
  }

  // O(N^2) | O(1)
  private static int[] findPair(int[] arr, int target) {
    for (int i = 0; i < arr.length; i++) {
      for (int j = i + 1; j < arr.length; j++) {
        int currentSum = arr[i] + arr[j];
        if (currentSum == target) return new int[]{i, j};
      }
    }
    return new int[]{-1, -1};
  }

  // O(N) | O(N)
  private static int[] findPair3(int[] arr, int target) {
    HashMap<Integer, Integer> hash = new HashMap<>();
    for (int i = 0; i < arr.length; i++) {
      int req = target - arr[i];
      if (hash.containsKey(req)) return new int[]{hash.get(req), i};
      hash.put(arr[i], i);
    }
    return new int[]{-1, -1};
  }
}
