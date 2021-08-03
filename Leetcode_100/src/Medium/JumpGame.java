package Medium;

public class JumpGame {

  public static void main(String[] args) {
    int[] arr = new int[]{2, 3, 1, 1, 4};
    System.out.println(canJump(arr));
  }

  public static boolean canJump(int[] nums) {
    int[] mem = new int[nums.length + 1];
    return canJump(nums, 0, mem);
  }

  private static boolean canJump(int[] nums, int idx, int[] mem) {
    if (idx >= nums.length) return false;
    if (idx == nums.length - 1) return true;

    if (mem[idx] != 0) return mem[idx] == 1 ? true : false;

    boolean isTrue = false;
    for (int i = 1; i <= nums[idx]; i++) {
      isTrue |= canJump(nums, idx + i, mem);
      if (isTrue) return true;
    }

    mem[idx] = isTrue ? 1 : -1;

    return isTrue;
  }
}
