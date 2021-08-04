package Medium;

public class SortColors {
  public static void main(String[] args) {
    int[] arr = new int[]{1, 0, 0, 1, 1, 1, 2, 2};
    sortColors(arr);
    for (int x : arr)
      System.out.print(x + " => ");
  }

  public static void sortColors(int[] nums) {

    int left = 0;
    int right = nums.length - 1;

    while (left <= right) {
      while (left < right && nums[left] == 0) left++;    // Left at Non Zero
      while (right > left && nums[right] != 0) right--;  // Right at Zero
      if (left >= right) break;
      int swap = nums[right];
      nums[right] = nums[left];
      nums[left] = swap;
      left++;
      right--;
    }

    // Keeping Left as It Is
    right = nums.length - 1;

    while (left <= right) {
      while (left < right && nums[left] == 1) left++;    // Left at Non Zero
      while (right > left && nums[right] != 1) right--;  // Right at Zero

      if (left >= right) break;
      int swap = nums[right];
      nums[right] = nums[left];
      nums[left] = swap;
      left++;
      right--;
    }

  }
}
