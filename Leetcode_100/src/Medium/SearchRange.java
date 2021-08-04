package Medium;

public class SearchRange {

  public static void main(String[] args) {
    int[] range = searchRange(new int[]{1, 2, 3, 4, 10, 10, 10, 10, 12, 16}, 10);
    System.out.println(range[0]);
    System.out.println(range[1]);
  }

  public static int[] searchRange(int[] nums, int target) {
    int[] res = new int[]{-1, -1};
    search(nums, target, 0, nums.length - 1, res, false);
    search(nums, target, 0, nums.length - 1, res, true);
    return res;
  }

  private static void search(int[] nums, int target, int left, int right, int[] res, boolean goLeft) {
    if (left > right) return;
    int mid = (left + right) / 2;
    if (nums[mid] > target) {
      search(nums, target, left, mid - 1, res, goLeft);
    } else if (nums[mid] < target) {
      search(nums, target, mid + 1, right, res, goLeft);
    } else {
      if (goLeft) {
        if (mid > 0 && nums[mid - 1] == nums[mid]) search(nums, target, left, mid - 1, res, goLeft);
        else res[0] = mid;
      } else {
        if (mid < nums.length - 1 && nums[mid + 1] == nums[mid]) search(nums, target, mid + 1, right, res, goLeft);
        else res[1] = mid;
      }
    }
  }
}
