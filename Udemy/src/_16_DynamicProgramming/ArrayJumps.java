package _16_DynamicProgramming;

public class ArrayJumps {
  public static void main(String[] args) {
    int[] arr = new int[]{3, 4, 2, 1, 2, 3, 10, 1, 1, 1, 2, 5};
    System.out.println(max(arr, 0));
  }

  static int infinite = 50000;

  static int max(int[] arr, int idx) {
    if (idx == arr.length - 1) return 0;
    if (idx >= arr.length) return infinite;

    int ways = infinite;
    for (int i = 1; i <= arr[idx]; i++) {
      ways = Math.min(ways, 1 + max(arr, idx + i));
    }

    return ways;
  }
}
