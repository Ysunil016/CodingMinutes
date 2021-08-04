package Medium;

public class FlattenBinaryTree {

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

  public static void flatten(TreeNode root) {
    if (root == null) return;
    flat(root);
  }

  private static void flat(TreeNode root) {
    if (root == null) return;

    if (root.left == null && root.right == null) return;

    flat(root.left);
    flat(root.right);

    TreeNode rightSub = root.right;
    root.right = root.left;
    root.left = null;

    while (root.right != null) root = root.right;
    root.right = rightSub;
  }
}
