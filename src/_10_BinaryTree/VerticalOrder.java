package _10_BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class VerticalOrder {

  public static void main(String[] args) {
    Tree root = new Tree(1);
    root.left = new Tree(2);
    root.right = new Tree(3);
    root.left.left = new Tree(4);
    root.left.right = new Tree(5);
    root.right.left = new Tree(6);
    root.right.right = new Tree(7);
    root.right.right.right = new Tree(9);
    root.right.left.right = new Tree(8);

    TreeMap<Integer, List<Integer>> verticalOrder = new TreeMap<>();

    verticalPrint(root, verticalOrder, 0);

    for (List<Integer> values : verticalOrder.values()) {
      System.out.println(values);
    }
  }

  static void verticalPrint(Tree tree, TreeMap<Integer, List<Integer>> verticalOrder, int order) {
    if (tree == null) return;
    if (verticalOrder.containsKey(order)) {
      List<Integer> elements = verticalOrder.get(order);
      elements.add(tree.val);
      verticalOrder.put(order, elements);
    } else {
      List<Integer> elements = new ArrayList<>();
      elements.add(tree.val);
      verticalOrder.put(order, elements);
    }
    verticalPrint(tree.left, verticalOrder, order - 1);
    verticalPrint(tree.right, verticalOrder, order + 1);
  }
}
