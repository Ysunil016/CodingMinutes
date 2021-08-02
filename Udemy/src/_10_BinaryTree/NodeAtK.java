package _10_BinaryTree;

public class NodeAtK {

  public static void main(String[] args) {
    Tree root = new Tree(1);
    root.left = new Tree(2);
    root.right = new Tree(3);
    root.left.left = new Tree(4);
    root.left.right = new Tree(5);
    root.left.right.left = new Tree(7);
    root.left.right.left.right = new Tree(8);
    root.left.right.left.left = new Tree(9);
    root.right.right = new Tree(6);

    System.out.println(nodeAtK(root, 5, 2));
  }

  static int nodeAtK(Tree root, int target, int k) {
    if (root == null) return -1;

    if (root.val == target) {
      printAtK(root, k);
      return 0;
    }

    int leftD = nodeAtK(root.left, target, k);
    if (leftD != -1) {
      if (leftD + 1 == k)
        System.out.println(root.val);
      else
        printAtK(root.right, k - 2 - leftD);
      return 1 + leftD;
    }

    int rightD = nodeAtK(root.right, target, k);
    if (rightD != -1) {
      if (rightD + 1 == k)
        System.out.println(root.val);
      else
        printAtK(root.left, k - 2 - rightD);
      return 1 + rightD;
    }
    return -1;
  }

  private static void printAtK(Tree root, int k) {
    if (root == null) return;
    if (k == 0) {
      System.out.println(root.val);
      return;
    }
    printAtK(root.left, k - 1);
    printAtK(root.right, k - 1);
  }
}
