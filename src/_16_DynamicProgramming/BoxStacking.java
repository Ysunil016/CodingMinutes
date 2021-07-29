package _16_DynamicProgramming;

import java.util.Arrays;
import java.util.HashMap;

public class BoxStacking {
  public static void main(String[] args) {
    int[][] boxes = new int[][]{{2, 1, 2}, {3, 2, 3}, {2, 2, 8}, {2, 3, 4}, {2, 2, 1}, {4, 4, 5}};
    Arrays.sort(boxes, (A, B) -> B[2] - A[2]);
    // Sort Since, we will always Move Forward, We Need Not to Look Back.
    System.out.println(maxStacking(boxes, -1, 0));
    System.out.println();
    System.out.println(maxStacking2(boxes, -1, 0));
    System.out.println();
    System.out.println(maxStacking2(boxes));
  }

  static HashMap<String, Integer> hash = new HashMap();

  // O(Exponential)
  private static int maxStacking(int[][] boxes, int prevAreaIdx, int idx) {
    if (idx >= boxes.length) return 0;

    int[] prevArea = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};
    if (prevAreaIdx != -1) prevArea = boxes[prevAreaIdx];


    int prevWidth = prevArea[0];
    int prevBreadth = prevArea[1];
    int prevHeight = prevArea[2];


    int curWidth = boxes[idx][0];
    int curBreadth = boxes[idx][1];
    int curHeight = boxes[idx][2];

    if (curHeight < prevHeight && curBreadth < prevBreadth && curWidth < prevWidth) {
      return Math.max(
        curHeight + maxStacking(boxes, idx, idx + 1),
        maxStacking(boxes, prevAreaIdx, idx + 1)
      );
    } else {
      return maxStacking(boxes, prevAreaIdx, idx + 1);
    }
  }

  // O(Quadratic)
  private static int maxStacking2(int[][] boxes, int prevAreaIdx, int idx) {
    if (idx >= boxes.length) return 0;

    String key = idx + " " + prevAreaIdx;
    if (hash.containsKey(key)) return hash.get(key);

    int[] prevArea = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};
    if (prevAreaIdx != -1) prevArea = boxes[prevAreaIdx];


    int prevWidth = prevArea[0];
    int prevBreadth = prevArea[1];
    int prevHeight = prevArea[2];


    int curWidth = boxes[idx][0];
    int curBreadth = boxes[idx][1];
    int curHeight = boxes[idx][2];

    int maxStack = 0;

    if (curHeight < prevHeight && curBreadth < prevBreadth && curWidth < prevWidth) {
      maxStack = Math.max(
        curHeight + maxStacking2(boxes, idx, idx + 1),
        maxStacking2(boxes, prevAreaIdx, idx + 1)
      );
    } else {
      maxStack = maxStacking2(boxes, prevAreaIdx, idx + 1);
    }

    hash.put(key, maxStack);
    return maxStack;
  }

  // O(Quadratic)
  private static int maxStacking2(int[][] boxes) {

    int[] dp = new int[boxes.length];
    for (int i = 0; i < dp.length; i++)
      dp[i] = boxes[i][2];

    int maxStack = dp[0];
    for (int i = 1; i < boxes.length; i++) {
      int[] currentBox = boxes[i];
      for (int j = 0; j < i; j++) {
        int[] prevBox = boxes[j];
        if (prevBox[0] > currentBox[0] && prevBox[1] > currentBox[1] && prevBox[2] > currentBox[2])
          dp[i] = Math.max(dp[i], currentBox[2] + dp[j]);
        maxStack = Math.max(maxStack, dp[i]);
      }
    }

    return maxStack;
  }

}
