package Array;

public class Rain {
  public static void main(String[] args) {
    int[] heights = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
    System.out.println(rainTrap(heights));
  }

  // O(N) | O(N)

  static int rainTrap(int[] arr) {
    int water = 0;

    if (arr.length <= 2) return 0;

    int[] leftToRight = findMax(arr, true);
    int[] rightToLeft = findMax(arr, false);

    for (int i = 0; i < arr.length; i++) {
      int minHeight = Math.min(leftToRight[i], rightToLeft[i]);
      if (arr[i] < minHeight) water += minHeight - arr[i];
    }

    return water;
  }

  private static int[] findMax(int[] arr, boolean isleft) {
    int[] res = new int[arr.length];
    if (isleft) {
      int maxCurrent = arr[0];
      for (int i = 1; i < arr.length; i++) {
        res[i] = maxCurrent;
        if (arr[i] > maxCurrent) {
          maxCurrent = arr[i];
        }
      }
    } else {
      int maxCurrent = arr[arr.length - 1];
      for (int i = arr.length - 2; i >= 0; i--) {
        res[i] = maxCurrent;
        if (arr[i] > maxCurrent) {
          maxCurrent = arr[i];
        }
      }
    }
    return res;
  }
}
