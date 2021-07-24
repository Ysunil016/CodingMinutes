package Array;

import java.util.HashMap;

public class TripletIndices {

  public static void main(String[] args) {
    int[] arr = new int[]{7, -5, 3, 4, -2};
    int[] res = triplet(arr, 6);
    System.out.println(res[0] + " " + res[1] + " " + res[2]);

    int[] res2 = triplet2(arr, 6);
    System.out.println(res2[0] + " " + res2[1] + " " + res2[2]);
  }

  // O(N^3) | O(1)

  private static int[] triplet(int[] arr, int target) {
    for (int i = 0; i < arr.length; i++) {
      for (int j = i + 1; j < arr.length; j++) {
        for (int k = j + 1; k < arr.length; k++) {
          int currentSum = arr[i] + arr[j] + arr[k];
          if (currentSum == target) return new int[]{i, j, k};
        }
      }
    }
    return new int[]{-1, -1, -1};
  }

  // O(N^2) | O(1)

  private static int[] triplet2(int[] arr, int target) {
    HashMap<Integer, Integer[]> hash = new HashMap<>();
    for (int i = 0; i < arr.length; i++) {
      int req = target - arr[i];
      if (hash.containsKey(req)) {
        Integer[] group = hash.get(req);
        return new int[]{group[0], group[1], i};
      }

      for (int k = 0; k < i; k++) {
        int keySum = arr[i] + arr[k];
        hash.put(keySum, new Integer[]{k, i});
      }
    }
    return new int[]{-1, -1, -1};
  }

}
