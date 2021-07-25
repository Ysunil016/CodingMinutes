package _04_SlidingWindow.Exercise;

import java.util.HashMap;

public class CountSubArrayWithTargetSum {
  public static void main(String[] args) {
    int[] nums = new int[]{10, 2, -2, -20, 10};
    System.out.println(count(nums, -10));
    System.out.println(count2(nums, -10));
  }

  // O(N^2) | O(1)
  static int count(int[] nums, int target) {
    int count = 0;
    for (int i = 0; i < nums.length; i++) {
      int sum = 0;
      for (int j = i; j < nums.length; j++) {
        sum += nums[j];
        if (target == sum) count++;
      }
    }
    return count;
  }

  // O(N^2) | O(N)
  static int count2(int[] arr, int target) {
    HashMap<Integer, Integer> prevSum = new HashMap<>();
    int res = 0;
    int currsum = 0;
    for (int i = 0; i < arr.length; i++) {

      currsum += arr[i];

      if (currsum == target)
        res++;

      if (prevSum.containsKey(currsum - target))
        res += prevSum.get(currsum - target);

      Integer count = prevSum.get(currsum);
      if (count == null)
        prevSum.put(currsum, 1);
      else
        prevSum.put(currsum, count + 1);
    }

    return res;
  }

}
