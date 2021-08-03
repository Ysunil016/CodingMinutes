package Medium;

import java.util.Arrays;

public class JumpGameII {

  public static void main(String[] args) {
    int[] arr = new int[]{2, 3, 1, 1, 4};
    System.out.println(jump(arr));
  }

  public static int jump(int[] nums) {
    int[] mem = new int[nums.length + 1];
    Arrays.fill(mem, -1);
    return jump(nums, 0, mem);
  }

  static int infinite = 1000001;

  private static int jump(int[] nums, int idx, int[] mem) {
    if (idx == nums.length - 1) return 0;
    if (idx >= nums.length) return infinite;

    if (mem[idx] != -1) return mem[idx];

    int maxSteps = nums[idx];
    int ways = infinite;
    for (int i = 1; i <= maxSteps; i++) {
      ways = Math.min(ways, 1 + jump(nums, idx + i, mem));
    }

    mem[idx] = ways;

    return ways;
  }
}
