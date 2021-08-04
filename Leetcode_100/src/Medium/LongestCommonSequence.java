package Medium;

import java.util.HashSet;

public class LongestCommonSequence {

  public static void main(String[] args) {
    int[] arr = new int[]{0,3,7,2,5,8,4,6,0,1};
    System.out.println(longestConsecutive(arr));
  }

  public static int longestConsecutive(int[] nums) {
    if(nums.length == 0) return 0;

    HashSet<Integer> set = new HashSet<>();
    for (int x : nums) set.add(x);

    int maxLen = 1;
    for (int x : nums) {

      int max = 1;
      int left = x - 1;
      int right = x + 1;
      while (set.contains(left)) {
        max++;
        set.remove(left--);
      }
      while (set.contains(right)) {
        max++;
        set.remove(right++);
      }

      maxLen = Math.max(maxLen, max);
    }
    return maxLen;
  }
}
