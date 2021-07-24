package Array.Exercise;

import java.util.Arrays;

public class ArrayProduct {

  public static void main(String[] args) {
    int[] arr = new int[]{1, 2, 3, 4, 5};
    int[] res = arrayProduct(arr);
    for (int r : res)
      System.out.println(r + " ");
  }

  private static int[] arrayProduct(int[] arr) {
    int[] res = new int[arr.length];

    int[] left = new int[arr.length];
    Arrays.fill(left, 1);
    int[] right = new int[arr.length];
    Arrays.fill(right, 1);

    for (int i = 1; i < arr.length; i++)
      left[i] *= arr[i - 1] * left[i - 1];

    for (int i = arr.length - 2; i >= 0; i--)
      right[i] *= arr[i + 1] * right[i + 1];

    for (int i = 0; i < arr.length; i++) {
      res[i] = left[i] * right[i];
    }

    return res;
  }

}
