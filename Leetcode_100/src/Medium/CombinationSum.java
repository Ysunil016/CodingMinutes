package Medium;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

  public static void main(String[] args) {
    for (List<Integer> res : combinationSum(new int[]{2, 3, 6, 7}, 8)) {
      for (int x : res)
        System.out.print(x + " ");
      System.out.println();
    }
  }

  static List<List<Integer>> result = new ArrayList<>();

  public static List<List<Integer>> combinationSum(int[] candidates, int target) {
    result.clear();
    dfs(candidates, target, 0, new ArrayList<>(), 0);
    return result;
  }

  private static void dfs(int[] candidates, int target, int idx, List<Integer> res, int currentSum) {
    if (currentSum == target) {
      result.add(res);
      return;
    }
    if (currentSum > target || idx >= candidates.length) return;

    List<Integer> res2 = new ArrayList<>(res);
    res2.add(candidates[idx]);
    dfs(candidates, target, idx, res2, currentSum + candidates[idx]);

    dfs(candidates, target, idx + 1, res, currentSum);
  }
}
