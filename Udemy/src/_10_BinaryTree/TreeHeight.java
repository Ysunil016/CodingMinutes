package _10_BinaryTree;

public class TreeHeight {
  public static void main(String[] args) {
    Tree root = new Tree(1);
    root.left = new Tree(2);
    root.right = new Tree(3);
    root.left.left = new Tree(4);
    root.left.right = new Tree(5);
    root.left.right.left = new Tree(7);
    root.right.right = new Tree(6);

    System.out.println("Height "+ height(root));
  }

  // O(N)
  static int height(Tree tree) {
    if (tree == null) return 0;
    return Math.max(height(tree.left), height(tree.right)) + 1;
  }
}
