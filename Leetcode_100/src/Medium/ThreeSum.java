package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

  public static void main(String[] args) {
    for (List<Integer> r : threeSum(new int[]{-1, 0, 1, 2, -1, -4})) {
      for (int x : r)
        System.out.print(x + " ");
      System.out.println();
    }
  }

  public static List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> result = new ArrayList<>();

    for (int i = 0; i < nums.length; i++) {
      int left = i + 1;
      int right = nums.length - 1;

      if (i > 0 && nums[i] == nums[i - 1]) continue;

      while (left < right) {
        int currentSum = nums[i] + nums[left] + nums[right];
        if (currentSum < 0) {
          left++;
        } else if (currentSum > 0) {
          right--;
        } else {
          result.add(List.of(nums[i], nums[left], nums[right]));
          while (left < nums.length - 1 && nums[left] == nums[left + 1]) left++;
          while (right > left && nums[right] == nums[right - 1]) right--;
          left++;
          right--;
        }
      }
    }

    return result;
  }
}
