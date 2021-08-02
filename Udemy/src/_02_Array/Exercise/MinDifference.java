package _02_Array.Exercise;

import java.util.Arrays;

public class MinDifference {

  public static void main(String[] args) {
    int[] A = new int[]{23, 5, 10, 17, 30};
    int[] B = new int[]{26, 134, 135, 14, 19};
    int[] res = minDifference(A, B);
    System.out.println(res[0] + " " + res[1]);
  }

  static int[] minDifference(int[] A, int[] B) {
    // Sorting the Arrays
    Arrays.sort(A);
    Arrays.sort(B);

    int min_Difference = Integer.MAX_VALUE;
    int aPointer = 0;
    int bPointer = 0;
    int[] res = new int[]{-1, -1};

    // Traversing Both the Arrays.
    while (aPointer < A.length && bPointer < B.length) {
      int difference = Math.abs(A[aPointer] - B[bPointer]);

      if (difference < min_Difference) {
        res[0] = A[aPointer];
        res[1] = B[bPointer];
        min_Difference = difference;
      }

      if (A[aPointer] < B[bPointer]) aPointer++;
      else bPointer++;
    }
    return res;
  }
}
