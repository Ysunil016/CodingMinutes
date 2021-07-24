package Array.Exercise;

public class MaxSubArraySum {
  public static void main(String[] args) {
    int[] nums = new int[]{-1, 2, 3, 4, -2, 6, -8, 3};
    System.out.println(findMaxSubArraySum(nums));
    System.out.println(findMaxSubArraySum2(nums));
  }

  // O(N^2) | O(1)
  private static int findMaxSubArraySum(int[] nums) {
    int maxSum = 0;
    for (int i = 0; i < nums.length; i++) {
      int subArraySum = nums[i];
      for (int j = i + 1; j < nums.length; j++) {
        subArraySum += nums[j];
        maxSum = Math.max(maxSum, subArraySum);
      }
    }
    return maxSum;
  }

  // O(N) | O(1)
  // Kadane's Algo
  private static int findMaxSubArraySum2(int[] nums) {
    int maxSumSoFar = Integer.MIN_VALUE;
    int maxYet = 0;
    for (int i = 0; i < nums.length; i++) {
      maxYet = Math.max(maxYet + nums[i], nums[i]);
      maxSumSoFar = Math.max(maxSumSoFar, maxYet);
    }
    return maxSumSoFar;
  }

}
