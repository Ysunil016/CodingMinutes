package Medium;

import java.util.HashMap;

public class TargetSum {

  public static void main(String[] args) {
    int[] arr = new int[]{2, 3, 6, 7, 7, 2, 4, 5, 6, 1, 3, 1, 2, 3, 4};
    System.out.println(findTargetSumWays(arr, 6));
  }

  public static int findTargetSumWays(int[] nums, int target) {
    HashMap<String, Integer> hash = new HashMap<>();
    return ways(nums, 0, 0, target, hash);
  }


  private static int ways(int[] nums, int current, int idx, int target, HashMap<String, Integer> hash) {
    if (idx == nums.length && current == target) return 1;
    if (idx >= nums.length) return 0;

    String key = idx + " " + current;
    if (hash.containsKey(key)) return hash.get(key);

    int ways = ways(nums, current - nums[idx], idx + 1, target, hash) +
      ways(nums, current + nums[idx], idx + 1, target, hash);

    hash.put(key, ways);
    return ways;
  }
}
