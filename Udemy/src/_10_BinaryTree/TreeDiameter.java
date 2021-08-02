package _10_BinaryTree;

public class TreeDiameter {

  public static void main(String[] args) {
    Tree root = new Tree(1);
    root.left = new Tree(2);
    root.right = new Tree(3);
    root.left.left = new Tree(4);
    root.left.right = new Tree(5);
    root.left.right.left = new Tree(7);
    root.right.right = new Tree(6);

    System.out.println(diameter(root));
    System.out.println("Diameter : " + diameter2(root).diameter + " Height : " + diameter2(root).height);
    System.out.println();

    int[] result = {Integer.MIN_VALUE};
    diameter3(root, result);
    System.out.println("Height : " + (result[0] - 1));
  }

  // O(N^2) - Calculating Height at Each Point
  static int diameter(Tree tree) {
    if (tree == null) return 0;

    int D1 = tree.height(tree.left) + tree.height(tree.right);
    int D2 = diameter(tree.left);
    int D3 = diameter(tree.right);

    return Math.max(D1, Math.max(D2, D3));
  }


  static class HeightDiameter {
    int height;
    int diameter;

    public HeightDiameter(int height, int diameter) {
      this.height = height;
      this.diameter = diameter;
    }
  }

  // O(N)
  static HeightDiameter diameter2(Tree tree) {
    HeightDiameter hd = new HeightDiameter(0, 0);
    if (tree == null) return hd;

    HeightDiameter left = diameter2(tree.left);
    HeightDiameter right = diameter2(tree.right);

    hd.height = Math.max(left.height, right.height) + 1;

    int height = left.height + right.height;
    int leftDiameter = left.diameter;
    int rightDiameter = right.diameter;

    hd.diameter = Math.max(height, Math.max(leftDiameter, rightDiameter));
    return hd;
  }

  // O(N)
  static int diameter3(Tree tree, int[] res) {
    if (tree == null) return 0;

    int left = diameter3(tree.left, res);
    int right = diameter3(tree.right, res);

    int asPart = Math.max(left, right) + 1;
    int asSol = 1 + left + right;

    int toBeTaken = Math.max(asPart, asSol);

    res[0] = Math.max(res[0], toBeTaken);

    return asPart;
  }


}
