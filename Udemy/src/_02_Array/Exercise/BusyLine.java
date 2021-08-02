package _02_Array.Exercise;

import java.util.Arrays;

public class BusyLine {

  public static void main(String[] args) {
    int[][] arr = new int[][]{{1, 2}, {2, 3}, {3, 4}, {2, 8}, {5, 6}, {6, 7}, {7, 8}, {8, 9}};
    System.out.println(maxTask(arr));
  }

  static int maxTask(int[][] arr) {
    Arrays.sort(arr, (A, B) -> (A[0] - B[0]));

    int[][] mem = new int[arr.length + 1][arr.length + 1];
    for (int[] x : mem) Arrays.fill(x, -1);
    return find(arr, 0, -1, mem);
  }

  static int optimal = 0;

  private static int find(int[][] arr, int idx, int prevIdx, int[][] mem) {
    optimal++;
    if (idx >= arr.length) return 0;

    if (prevIdx == -1) return Math.max(
      1 + find(arr, idx + 1, idx, mem),
      find(arr, idx + 1, prevIdx, mem)
    );

    if (mem[idx][prevIdx] != -1) return mem[idx][prevIdx];

    if (arr[prevIdx][1] <= arr[idx][0])
      mem[idx][prevIdx] = Math.max(
        1 + find(arr, idx + 1, idx, mem),
        find(arr, idx + 1, prevIdx, mem)
      );
    else {
      mem[idx][prevIdx] = find(arr, idx + 1, prevIdx, mem);
    }

    return mem[idx][prevIdx];
  }
}
