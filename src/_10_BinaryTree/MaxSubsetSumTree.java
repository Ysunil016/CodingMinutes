package _10_BinaryTree;

public class MaxSubsetSumTree {
  public static void main(String[] args) {
    Tree root = new Tree(1);
    root.left = new Tree(2);
    root.right = new Tree(3);
    root.left.left = new Tree(4);
    root.left.right = new Tree(5);
    root.left.right.left = new Tree(7);
    root.right.right = new Tree(6);

    Node rootMax = max(root);
    System.out.println(Math.max(rootMax.include, rootMax.exclude));
    System.out.println();
    System.out.println(max2(root));
  }

  static class Node {
    int include = 0;
    int exclude = 0;
  }

  // O(N)
  static Node max(Tree tree) {
    if (tree == null) return new Node();

    Node left = max(tree.left);
    Node right = max(tree.right);

    Node newNode = new Node();
    newNode.include = tree.val + left.exclude + right.exclude;
    newNode.exclude = Math.max(left.include, left.exclude) + Math.max(right.include, right.exclude);

    return newNode;
  }

  // O(Exponential)
  static int max2(Tree tree) {
    if (tree == null) return 0;
    return Math.max(include(tree), exclude(tree));
  }

  private static int include(Tree tree) {
    if (tree == null) return 0;
    return tree.val + exclude(tree.left) + exclude(tree.right);
  }

  static int exclude(Tree tree) {
    if (tree == null) return 0;
    return Math.max(include(tree.left), exclude(tree.left)) + Math.max(include(tree.right), exclude(tree.right));
  }
}
