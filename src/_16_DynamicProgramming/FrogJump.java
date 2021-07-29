package _16_DynamicProgramming;

import java.util.Arrays;

public class FrogJump {

  public static void main(String[] args) {
//    int[] height = new int[]{10, 10};

//    int[] height = new int[]{30, 10, 60, 10, 60, 50};

    int[] height = new int[]{10, 30, 40, 20};

    int startIdx = 0;
    int[] mem = new int[height.length + 1];

    System.out.println(minCost(height, startIdx));
    System.out.println();
    Arrays.fill(mem, -1);
    System.out.println(minCost(height, startIdx, mem));
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

  // O(n^2)
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
}
