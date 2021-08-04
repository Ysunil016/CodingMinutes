package Medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Subset {

  public static void main(String[] args) {
    System.out.println(subsets(new int[]{1, 2, 3}));
  }

  public static List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    res.add(new ArrayList<>());
    solve(nums, res);
    return res;
  }

  private static void solve(int[] nums, List<List<Integer>> result) {
    for (int x : nums) {
      List<List<Integer>> currentListArray = new ArrayList<>();
      for (List<Integer> rrs : result) {
        List<Integer> currentList = new ArrayList<>(rrs);
        currentList.add(x);
        currentListArray.add(currentList);
      }
      result.addAll(currentListArray);
    }
  }
}
