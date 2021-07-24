package Array;

import java.util.Arrays;
import java.util.HashMap;

public class Triplet {

  public static void main(String[] args) {
    int[] arr = new int[]{7, -5, 3, 4, -2};
    int[] res = triplet(arr, 6);
    System.out.println(res[0] + " " + res[1] + " " + res[2]);

    int[] res2 = triplet2(arr, 6);
    System.out.println(res2[0] + " " + res2[1] + " " + res2[2]);

    int[] res3 = triplet3(arr, 6);
    System.out.println(res3[0] + " " + res3[1] + " " + res3[2]);
  }

  // O(N^3) | O(1)  - Using Loops

  private static int[] triplet(int[] arr, int target) {
    Arrays.sort(arr);
    for (int i = 0; i < arr.length; i++) {
      for (int j = i + 1; j < arr.length; j++) {
        for (int k = j + 1; k < arr.length; k++) {
          int currentSum = arr[i] + arr[j] + arr[k];
          if (currentSum == target) return new int[]{arr[i], arr[j], arr[k]};
        }
      }
    }
    return new int[]{-1, -1, -1};
  }

  // O(N^2) | O(1)  - Using Hash

  private static int[] triplet2(int[] arr, int target) {
    Arrays.sort(arr);
    HashMap<Integer, Integer[]> hash = new HashMap<>();
    for (int i = 0; i < arr.length; i++) {
      int req = target - arr[i];
      if (hash.containsKey(req)) {
        Integer[] group = hash.get(req);
        return new int[]{group[0], group[1], arr[i]};
      }

      for (int k = 0; k < i; k++) {
        int keySum = arr[i] + arr[k];
        hash.put(keySum, new Integer[]{arr[k], arr[i]});
      }
    }
    return new int[]{-1, -1, -1};
  }

  // O(N^2) | O(1) - Using Sort.

  private static int[] triplet3(int[] arr, int target) {
    Arrays.sort(arr);

    for (int i = 0; i < arr.length; i++) {
      int left = i + 1;
      int right = arr.length - 1;
      int req = target - arr[i];
      while (left < right) {
        int currentSum = arr[left] + arr[right];
        if (currentSum == req) return new int[]{arr[i], arr[left], arr[right]};
        if (currentSum < req)
          left++;
        else
          right--;
      }
    }
    return new int[]{-1, -1, -1};
  }

}
