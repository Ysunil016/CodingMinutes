package Medium;

public class ValidBST {

  public static void main(String[] args) {
    TreeNode root = new TreeNode(100);
    System.out.println(isValidBST(root));
  }

  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
      this.val = val;
    }
  }

  public static boolean isValidBST(TreeNode root) {
    if (root == null) return true;
    return valid(root, Long.MIN_VALUE, Long.MAX_VALUE);
  }

  private static boolean valid(TreeNode root, long min, long max) {
    if (root == null) return true;

    if(root.val <= min || root.val >= max) return false;

    return valid(root.left, min, root.val) && valid(root.right, root.val, max);
  }
}
