package _02_Array;

public class Mountain {
  public static void main(String[] args) {
    int[] arr = new int[]{5, 6, 1, 2, 3, 4, 5, 4, 3, 2, 1, 0, 1, 2, 3, -2, 4};
    System.out.println(maxPeakLength(arr));

    arr = new int[]{0, 1, 2, 3, 4, 5, 6, 5, 4, 3, 2, 1, 0};
    System.out.println(maxPeakLength(arr));
  }

  private static int maxPeakLength(int[] arr) {
    int maxLen = 0;

    // Find Peak;
    for (int i = 1; i < arr.length - 2; i++) {
      int leftElement = arr[i - 1];
      int rightElement = arr[i + 1];
      boolean isPeak = arr[i] > leftElement && arr[i] > rightElement;

      if (isPeak) {
        int lengthForPeak = 0;

        int left = i;
        int right = i;
        while (left > 0 && arr[left] > arr[left - 1]) {
          lengthForPeak++;
          left--;
        }
        while (right < arr.length - 1 && arr[right] > arr[right + 1]) {
          lengthForPeak++;
          right++;
        }

        maxLen = Math.max(maxLen, lengthForPeak);
      }
    }

    return maxLen;
  }
}
