package Medium;

public class HouseRobberIII {

  public static void main(String[] args) {
    TreeNode root = new TreeNode(20);
    System.out.println(rob(root));
  }

  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

  static class Pair {
    int with = 0;
    int without = 0;
  }

  public static int rob(TreeNode root) {
    Pair pair = solve(root);
    return Math.max(pair.with, pair.without);
  }

  private static Pair solve(TreeNode root) {
    if (root == null) return new Pair();

    Pair left = solve(root.left);
    Pair right = solve(root.right);

    Pair curr = new Pair();

    curr.with += left.without + right.without + root.val;
    curr.without += Math.max(left.with, left.without) + Math.max(right.with, right.without);

    return curr;
  }
}
