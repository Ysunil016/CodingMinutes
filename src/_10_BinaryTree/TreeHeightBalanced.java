package _10_BinaryTree;

public class TreeHeightBalanced {
  public static void main(String[] args) {
    Tree root = new Tree(1);
    root.left = new Tree(2);
    root.right = new Tree(3);
    root.left.left = new Tree(4);
    root.left.right = new Tree(5);
    root.left.right.left = new Tree(7);
    root.right.right = new Tree(6);
    root.left.right.left.right = new Tree(8);

    isBalancedHeight(root);

    System.out.println("Is Height Balanced ? " + isBalanced);
  }

  static boolean isBalanced = true;

  // O(N)
  static int isBalancedHeight(Tree tree) {
    if (tree == null) return 0;
    int left = isBalancedHeight(tree.left);
    int right = isBalancedHeight(tree.right);

    if (Math.abs(left - right) > 1) isBalanced = false;

    return Math.max(left, right) + 1;
  }
}
