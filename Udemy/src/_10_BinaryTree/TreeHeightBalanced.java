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

    Node isBalanced = isBalancedHeight2(root);
    System.out.println("Is Height Balanced ? " + isBalanced.isBalanced);
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

  static class Node {
    int height = 0;
    boolean isBalanced = true;

    public Node(int height, boolean isBalanced) {
      this.height = height;
      this.isBalanced = isBalanced;
    }
  }

  // O(N)
  static Node isBalancedHeight2(Tree tree) {
    if (tree == null) return new Node(0, true);
    Node left = isBalancedHeight2(tree.left);
    Node right = isBalancedHeight2(tree.right);

    int height = 1 + Math.max(left.height, right.height);

    if (left.isBalanced && right.isBalanced)
      if (Math.abs(left.height - right.height) > 1)
        return new Node(height, false);
      else
        return new Node(height, true);
    else
      return new Node(height, false);
  }
}
