package _04_SlidingWindow;

import java.util.ArrayList;
import java.util.List;

public class Housing {

  public static void main(String[] args) {
    int[] arr = new int[]{1, 3, 2, 1, 4, 1, 3, 2, 1, 1, 2};
    List<int[]> finalRes = houseCount(arr, 8);

    for (int[] f : finalRes)
      System.out.println(f[0] + " " + f[1]);

    System.out.println();

    finalRes = houseCount2(arr, 8);
    for (int[] f : finalRes)
      System.out.println(f[0] + " " + f[1]);
  }

  // O(N^2) | O(1)
  private static List<int[]> houseCount(int[] arr, int area) {
    List<int[]> res = new ArrayList<>();
    for (int i = 0; i < arr.length; i++) {
      int sum = 0;
      for (int j = i; j < arr.length; j++) {
        sum += arr[j];
        if (sum == area) {
          res.add(new int[]{i, j});
        }
      }
    }
    return res;
  }

  // 1, 3, 2, 1, 4, 1, 3, 2, 1, 1, 2
  // O(N) | O(1)
  private static List<int[]> houseCount2(int[] arr, int area) {
    List<int[]> res = new ArrayList<>();
    int left = 0;
    int right = 0;
    int sum = arr[left];

    while (left <= right && right < arr.length - 1) {
      if (sum == area) {
        res.add(new int[]{left, right});
        right++;
        sum += arr[right];
      } else if (sum < area) {
        right++;
        sum += arr[right];
      } else {
        sum -= arr[left];
        left++;
      }
    }
    return res;
  }
}
