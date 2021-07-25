package _10_BinaryTree;

public class ReplaceWithDescendantSum {
  public static void main(String[] args) {
    Tree root = new Tree(1);
    root.left = new Tree(2);
    root.right = new Tree(3);
    root.left.left = new Tree(4);
    root.left.right = new Tree(5);
    root.left.right.left = new Tree(7);
    root.right.right = new Tree(6);

    replace(root);

    root.inOrder();
  }

  static int replace(Tree tree) {
    if (tree == null) return 0;
    if (tree.left == null && tree.right == null) return tree.val;

    int left = replace(tree.left);
    int right = replace(tree.right);

    int descendentSum = left + right;
    int currentValue = tree.val;
    tree.val = descendentSum;

    return currentValue + left + right;
  }
}
