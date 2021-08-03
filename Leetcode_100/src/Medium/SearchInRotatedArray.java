package Medium;

public class SearchInRotatedArray {

  public static void main(String[] args) {
    int[] arr = new int[]{9, 10, 11, 1, 2, 3};
    System.out.println(search(arr, 10));
  }

  public static int search(int[] nums, int target) {
    return bst(nums, target, 0, nums.length - 1);
  }

  private static int bst(int[] nums, int target, int left, int right) {
    if (left > right) return -1;

    int mid = (left + right) / 2;

    if (nums[mid] == target) return mid;

    if (nums[mid] < nums[right]) {
      if (target <= nums[right] && target > nums[mid]) return bst(nums, target, mid + 1, right);
      else return bst(nums, target, left, mid - 1);
    } else {
      if (target < nums[mid] && target >= nums[left]) return bst(nums, target, left, mid - 1);
      else return bst(nums, target, mid + 1, right);
    }
  }
}
