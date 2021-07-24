package Array;

public class SubArraySort {
  public static void main(String[] args) {
    int[] arr = new int[]{1, 2, 3, 4, 5, 8, 6, 7, 9, 10, 11};
    int[] res = indicesToSort(arr);
    System.out.println(res[0] + " " + res[1]);

    arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
    res = indicesToSort(arr);
    System.out.println(res[0] + " " + res[1]);

    arr = new int[]{9, 3, 3, 4, 5, 6, 7, 8, 9, 10, 11};
    res = indicesToSort(arr);
    System.out.println(res[0] + " " + res[1]);
  }

  static int[] indicesToSort(int[] arr) {
    int[] minMax = new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};

    // Find the Defected Min and Max Value
    for (int i = 0; i < arr.length - 1; i++) {
      int current = arr[i];
      int next = arr[i + 1];
      if (current > next) {
        minMax[0] = Math.min(minMax[0], next);
        minMax[1] = Math.max(minMax[1], current);
      }
    }
    // Check if Array is Already Sorted
    if (minMax[0] == Integer.MIN_VALUE) return new int[]{-1, -1};

    // Find the Proper Indices of Min and Max
    int leftRange = -1;
    int rightRange = -1;

    for (int i = 0; i < arr.length; i++) {
      if (arr[i] > minMax[0]) {
        leftRange = i;
        break;
      }
    }
    for (int i = arr.length - 1; i >= 0; i--) {
      if (arr[i] < minMax[1]) {
        rightRange = i;
        break;
      }
    }

    return new int[]{leftRange, rightRange};
  }
}
