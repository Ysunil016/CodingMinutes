package _16_DynamicProgramming;

import java.util.Arrays;

public class FrogJump {

  public static void main(String[] args) {
//    int[] height = new int[]{10, 10};

    int[] height = new int[]{30, 10, 60, 10, 60, 50};

//    int[] height = new int[]{10, 30, 40, 20};

    int startIdx = 0;
    int[] mem = new int[height.length + 1];

    System.out.println(minCost(height, startIdx));
    System.out.println();
    Arrays.fill(mem, -1);
    System.out.println(minCost(height, startIdx, mem));
    System.out.println();
    System.out.println(minCost(height));
  }

  static int infinite = 50000;

  // O(n^2)
  private static int minCost(int[] heights, int idx) {
    if (idx == heights.length - 1) return 0;
    if (idx >= heights.length) return infinite;

    int oneStep = Integer.MAX_VALUE;
    int twoStep = Integer.MAX_VALUE;

    if (idx < heights.length - 1)
      oneStep = Math.abs(heights[idx + 1] - heights[idx]) + minCost(heights, idx + 1);
    if (idx < heights.length - 2)
      twoStep = Math.abs(heights[idx + 2] - heights[idx]) + minCost(heights, idx + 2);

    return Math.min(oneStep, twoStep);
  }

  // O(n)
  private static int minCost(int[] heights, int idx, int[] mem) {
    if (idx == heights.length - 1) return 0;
    if (idx >= heights.length) return infinite;

    if (mem[idx] != -1) return mem[idx];

    int oneStep = Integer.MAX_VALUE;
    int twoStep = Integer.MAX_VALUE;

    if (idx < heights.length - 1)
      oneStep = Math.abs(heights[idx + 1] - heights[idx]) + minCost(heights, idx + 1, mem);
    if (idx < heights.length - 2)
      twoStep = Math.abs(heights[idx + 2] - heights[idx]) + minCost(heights, idx + 2, mem);

    mem[idx] = Math.min(oneStep, twoStep);

    return mem[idx];
  }

  // O(n) - Tabular
  private static int minCost(int[] heights) {
    int dp[] = new int[heights.length + 1];
    dp[1] = Math.abs(heights[1] - heights[0]);

    for (int i = 2; i < heights.length; i++) {
      int oneStep = Math.abs(heights[i] - heights[i - 1]) + dp[i - 1];
      int twoStep = Math.abs(heights[i] - heights[i - 2]) + dp[i - 2];
      dp[i] = Math.min(oneStep, twoStep);
    }

    return dp[heights.length - 1];
  }
}
