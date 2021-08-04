package Medium;

import java.util.Arrays;

public class canPartition {
  public static void main(String[] args) {
    System.out.println(canPartition(new int[]{1,5,11,5}));
  }

  public static boolean canPartition(int[] nums) {
    int sum = 0;
    for (int x : nums) sum += x;
    if (sum % 2 != 0) return false;
    int[][] mem = new int[nums.length + 1][sum + 1];
    for (int[] x : mem) Arrays.fill(x, -1);

    return solve(nums, sum, 0, 0, mem);
  }

  private static boolean solve(int[] nums, int sum, int current, int idx, int[][] mem) {
    if (idx >= nums.length) return false;
    if (current > sum / 2) return false;
    if (current == sum / 2) return true;

    if (mem[idx][current] != -1) return mem[idx][current] == 1;

    boolean isSolve = solve(nums, sum, current + nums[idx], idx + 1, mem) ||
      solve(nums, sum, current, idx + 1, mem);

    mem[idx][current] = isSolve ? 1 : 0;

    return isSolve;
  }
}
