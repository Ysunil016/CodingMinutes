package _10_BinaryTree.Exercise;

public class SiblingSwap {
  public static void main(String[] args) {

    Tree root = new Tree(6);
    root.left = new Tree(3);
    root.right = new Tree(8);
    root.left.left = new Tree(1);
    root.left.right = new Tree(7);
    root.right.left = new Tree(4);
    root.right.right = new Tree(2);
    root.right.right.right = new Tree(3);
    root.right.left.left = new Tree(7);
    root.right.left.right = new Tree(1);

    Tree root2 = new Tree(6);
    root2.left = new Tree(8);
    root2.right = new Tree(3);
    root2.left.left = new Tree(2);
    root2.left.left.left = new Tree(3);
    root2.left.right = new Tree(4);
    root2.left.right.left = new Tree(1);
    root2.left.right.right = new Tree(7);
    root2.right.left = new Tree(7);
    root2.right.right = new Tree(1);

    System.out.println(isValid(root, root2));

  }

  static boolean isValid(Tree one, Tree two) {
    if (one == null && two == null) return true;
    if (one == null || two == null) return false;

    if (one.val == two.val) {
      return isValid(one.left, two.right) || isValid(one.right, two.left);
    }
    return false;
  }
}
