package _10_BinaryTree.Exercise;

import java.util.ArrayList;
import java.util.List;

public class LeftView {

  public static void main(String[] args) {
    Tree root = new Tree(1);
    root.left = new Tree(2);
    root.right = new Tree(3);
    root.left.left = new Tree(4);
    root.left.right = new Tree(5);
    root.left.right.left = new Tree(7);
    root.right.right = new Tree(6);
    root.left.right.left.left = new Tree(9);
    root.left.right.left.right = new Tree(8);

    List<Integer> res = new ArrayList<>();
    leftView(root, res, 0);

    for (int x : res)
      System.out.println(x);
  }

  static void leftView(Tree tree, List<Integer> result, int level) {
    if (tree == null) return;
    if (result.size() == level)
      result.add(tree.val);
    leftView(tree.left, result, level + 1);
    leftView(tree.right, result, level + 1);
  }
}
