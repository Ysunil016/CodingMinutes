package _16_DynamicProgramming;

import java.util.Arrays;

public class MaxNonAdjSum {
  public static void main(String[] args) {
    int[] arr = new int[]{500, 1, 12, 7, 9, 14};
    System.out.println(maxSum(arr, 0));
    System.out.println();

    int[] mem = new int[arr.length];
    Arrays.fill(mem, -1);

    System.out.println(maxSum(arr, 0, mem));
    System.out.println();
    System.out.println(maxSum2(arr));
  }

  // O(Exponential)
  static int maxSum(int[] arr, int idx) {
    if (idx >= arr.length) return 0;
    return Math.max(arr[idx] + maxSum(arr, idx + 2), maxSum(arr, idx + 1));
  }

  // O(Linear - Recursion)
  static int maxSum(int[] arr, int idx, int[] mem) {
    if (idx >= arr.length) return 0;
    if (mem[idx] != -1) return mem[idx];
    return mem[idx] = Math.max(arr[idx] + maxSum(arr, idx + 2), maxSum(arr, idx + 1));
  }

  // O(Linear - Tabular)
  static int maxSum2(int[] arr) {
    int[] dp = new int[arr.length];
    dp[0] = arr[0];
    dp[1] = Math.max(dp[0], arr[1]);

    for (int i = 2; i < arr.length; i++) {
      dp[i] = Math.max(arr[i] + dp[i - 2], dp[i - 1]);
    }

    return dp[arr.length - 1];
  }
}
