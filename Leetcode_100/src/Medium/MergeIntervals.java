package Medium;

import java.util.Arrays;
import java.util.Stack;

public class MergeIntervals {

  public static void main(String[] args) {
    for (int[] x : merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}})) {
      System.out.println(x[0] + " " + x[1]);
    }
  }

  public static int[][] merge(int[][] intervals) {
    Arrays.sort(intervals, (A, B) -> A[0] - B[0]);

    Stack<int[]> stack = new Stack<>();
    for (int[] interval : intervals) {
      if (stack.isEmpty()) stack.push(interval);
      else {
        int[] top = stack.peek();
        if (interval[0] <= top[1]) {
          int[] poppedElement = stack.pop();
          stack.push(new int[]{poppedElement[0],Math.max(interval[1], poppedElement[1])});
        } else {
          stack.push(interval);
        }
      }
    }

    int[][] result = new int[stack.size()][2];

    int counter = result.length - 1;
    while (!stack.isEmpty()) {
      result[counter] = stack.pop();
      counter--;
    }

    return result;
  }
}
